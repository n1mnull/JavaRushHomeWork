package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by Alenka on 08.06.2016.
 */

public class FileStorageStrategy implements StorageStrategy
{
    /**
     * Начальная емкость. Это число бакетов в хеш-таблице, где бакет - элемент хеш-таблицы, что содержит список данных в нее положенных.
     * Всегда является степенью 2. Это позволяет некоторые оптимизации.
     * Когда фактор загрузки превышен, то хеш-таблица автоматически увеличивает свою емкость вдвое.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * Массив бакетов. Длина всегда равна степени двойки.
     * Увеличивается вдвое, если фактор загрузки превышен.
     */
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];

    /**
     * Количество мэппингов в хеш-таблице.
     */
    int size;

    /**
     * Максимальный размер бакета-файла
     */
    long bucketSizeLimit = 10000;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    /**
     * Хеширование.
     * Взято из реализации HashMap.
     */
    int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    /**
     * Получает индекс в массиве бакетов.
     * Взято из реализации HashMap.
     */
    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    /**
     * Entry по ключу.
     * Скопировано.
     */
    Entry getEntry(Long key) {
        int hash = hash(key); //Получаем хеш ключа для доступа к индексу.
        int index = indexFor(hash, table.length); //Получаем индекс.
        if (table[index] != null) { //Если в бакете с этим индексом есть что-то, то
            Entry e = table[index].getEntry(); //Берем оттуда Entry
            while (e != null) {
                if (e.getKey().equals(key)) //И проверяем его ключ на соответствие переданному.
                {
                    return e;
                }
                e = e.next; //Если ключ не соответствует, то переходим к следующему Entry.
            }
        }
        return null;
    }

    /**
     * Изменение размера массива бакетов.
     *
     * @param newCapacity новый размер.
     */
    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }


    void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) { //По всем бакетам.
            if (table[i] == null) continue; //Если null-бакет, то пропускать.
            Entry entry = table[i].getEntry(); //Получаем из каждого entry.
            while (entry != null) {
                Entry next = entry.next; //Запоминаем следующий за ним.
                int newIndex = indexFor(next.hash, newTable.length); //Получаем новый индекс для нового массива.
                if (newTable[newIndex] == null) {
                    entry.next = null; //Если по этому индексу пусто, то следующий Entry тоже должен быть null
                    newTable[newIndex] = new FileBucket(); //И зазаносим туда новый бакет.
                }
                else {
                    entry.next = newTable[newIndex].getEntry(); //Иначе следующий за данным получаем по его индексу.
                }
                newTable[newIndex].putEntry(entry); //Записываем этот Entry в файл.
                entry = next; //Переходим к следующему.
            }
            table[i].remove(); //Удаляем файлы, которые не используются.
        }
    }

    /**
     * Добавление Entry в бакет
     */
    void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry(); //Получаем Entry с соответствующим индексом.
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry)); //Пишем новый Entry на этот индекс, а предыдущий становится следующим за ним, передаваясь в конструкторе.
        size++; //Увеличиваем размер, т.к. добавили еще один Entry.
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) { //Размер массива бакетов удваиваем только в том случае, если один из них превысил максимальный объем.
            resize(2 * table.length);
        }
    }

    /**
     * Создание нового Entry
     */
    void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket(); //Новый бакет.
        table[bucketIndex].putEntry(new Entry(hash, key, value, null)); //Записываем туда новый Entry. Он будет крайним, значит следующий - null.
        size++; //Добавили - увеличи размер на 1.
    }

    @Override
    public boolean containsKey(Long key)
    {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value)
    {
        for (int i = 0; i < table.length; i++) { //По всем бакетам.
            if (table[i] == null) continue; //Пустые пропускаем.
            Entry entry = table[i].getEntry(); //Берем Entry из бакета.
            while (entry != null) { //Если null, значит Entry кончились.
                if (entry.getValue().equals(value)) { //Совпадает - true.
                    return true;
                }
                entry = entry.next; //Переходим к следующему.
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        int hash = hash(key); //Хеш ключа.
        int index = indexFor(hash, table.length); //Определяем индекс в таблице бакетов.
        if (table[index] != null) { //Если там не пусто
            Entry entry = table[index].getEntry(); //Проверяем все Entry, находим соответствующий ключу и заменяем его значение.
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index); //Если не нашли соответствующего Entry, то просто делаем новый и добавляем его на соответствующую позицию.
        }
        else {
            createEntry(hash, key, value, index); //Если в таблице по этому индексу ничего нет, то просто создаем новый Entry для этого индекса (ну и бакет заодно).
        }
    }

    @Override
    public Long getKey(String value)
    {
        for (int i = 0; i < table.length; i++) { //Проверяем все бакеты.
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry(); //Значение каждого Entry сравниваем с полученным, если соотвтетсвует, то возвращаем его ключ.
            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return entry.key;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        for (int i = 0; i < table.length; i++) { //Проверяем все бакеты.
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry(); //Ключ каждого Entry сравниваем с полученным, если соответствует, то возвращаем его значение.
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public long getBucketSizeLimit()
    {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit)
    {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
