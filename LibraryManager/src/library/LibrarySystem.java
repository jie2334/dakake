package library;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class LibrarySystem {

    private Library library;

    private Map<String, Reader> readerMap;


    public LibrarySystem(Library library, Map<String, Reader> readerMap) {
        this.library = library;
        this.readerMap = readerMap;
    }


    /**
     * 打印图书馆里面的所有书籍
     *
     * @return list
     */
    public List<Book> printBookByDate() {
        List<Book> list = getLibrary().getBookList();
        list.sort(Comparator.comparing(Book::getPublicationDate));
        return list;
    }


    /**
     * 图书馆借阅书籍
     *
     * @param reader
     * @throws ParseException
     */
    public List<BorrowRecord> startBorrow(Reader reader, String name) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat();
        /*判断是否map里面包含uuid*/
        Map<String, Reader> map = getReaderMap();
        boolean containsKey = map.containsKey(reader.getUuid());

        if (containsKey) {
            List<Book> bookList = library.getBookList();
            if (!(name == null)) {
                for (Book book : bookList) {
                    if (name.equals(book.getName()) && (!book.isBorrow())) {
                        System.out.println("该图书在馆,可以借阅!");
                        //bookList里面的此书状态改变,并且更新借阅时间
                        book.setBorrow(true);
                        //获取当前时间
                        Date date = new Date();
                        format.format(date);
                        book.setStorageDate(date);
                        //登记归还时间
                        Date returnDate = new Date();
                        //在此人的借阅记录里面新增一条借阅记录
                        //每个读者的借阅记录
                        List<BorrowRecord> recordList = reader.getRecordList();

                        recordList.add(new BorrowRecord(book, book.getStorageDate(), returnDate));
                        System.out.println("你的名字是: " + reader.getName());
                        return recordList;
                    }

                }
            }
        }
        return null;
    }


    /**
     * 归还书籍
     *
     * @return
     */
    public List<BorrowRecord> returnBook(Reader reader, String returnName) {


        if (reader==null||returnName.isEmpty()){
            throw new RuntimeException("不允许空值");
        }

        if (reader!=null){
            List<BorrowRecord> records = reader.getRecordList();
            //删除这条记录
            Iterator<BorrowRecord> iterator = records.listIterator();
            while (iterator.hasNext()) {
                BorrowRecord next = iterator.next();
                if (returnName.equals(next.getBook().getName())) {
                    System.out.println("输入正确,有这条记录");
                    //更新状态
                    Book recordBook = next.getBook();
                    recordBook.setBorrow(false);
                    recordBook.setStorageDate(null);
                    iterator.remove();
                }

            }
            return records;
        }
        return null;
    }

    /**
     * 读者注册写入reader的属性
     *
     * @param reader
     * @param pathName
     */
    public void saveOnFile(Reader reader, String pathName) {//假定传进来的路径是:  D://test//test.txt

        if (!(reader == null || pathName.isEmpty())) {
            //读者的uuid
            String readerUuid = reader.getUuid();
            //读者的name
            String name = reader.getName();
            //注册的时间
            String registrationTime = reader.getRegistrationTime().toString();
            //添加到readerMap中
            readerMap.put(readerUuid, reader);
            FileWriter writer = null;
            FileWriter fileWriter = null;
            try {
                writer = new FileWriter(pathName + "test.txt");

                writer.write(readerUuid);
                writer.append(":");
                writer.write(name);
                writer.append(":");
                writer.write(registrationTime);
                writer.close();

                //字符串拼接新建txt文件写入reader书籍
                File file = new File(pathName + readerUuid + ".txt");
                fileWriter = new FileWriter(file);

                List<BorrowRecord> recordList = readerMap.get(readerUuid).getRecordList();
                Iterator<BorrowRecord> iterator = recordList.iterator();

                //打印读者的每一个借阅记录
                while (iterator.hasNext()){
                    BorrowRecord next = iterator.next();
                    fileWriter.write(next.getBook().getName());
                    fileWriter.append(":");
                    fileWriter.write(next.getBook().getAuthor());
                    fileWriter.append(":");
                    fileWriter.write(String.valueOf(next.getBook().getPublicationDate()));
                    fileWriter.append(":");
                    fileWriter.write(String.valueOf(next.getBook().getStorageDate()));
                    fileWriter.append(":");
                    fileWriter.write(String.valueOf(next.getBook().isBorrow()));
                    fileWriter.write("/r/n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    writer.close();
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    /*/从文件中读取书籍*/
    public Map<String, Reader> readFile(Reader reader, String path) throws RuntimeException {

        if (reader==null&&path.isEmpty()){
            throw new RuntimeException("不允许空值!");
        }

        //获取当前map
        Map<String, Reader> map = getReaderMap();

        List<BorrowRecord> borrowRecords = new ArrayList<>();

        BufferedReader bufferedReader = null;
        //当system创建的时候 从文件中读出属性，保存到hashMap中
        try  {
            //读者文本
            FileReader readerTxt = new FileReader(path + ".txt");
            //读者书籍文本
            FileReader fileReader = new FileReader(path + reader.getUuid()+".txt");

             bufferedReader = new BufferedReader(readerTxt);

            while (bufferedReader.read()!=-1) {

                String line = bufferedReader.readLine();

                String[] split = line.split(":");
                String uuid = split[0];
                String name = split[1];
                String date = split[2];

                SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

                Date parse = format.parse(date);


                Reader newReader = new Reader(uuid, name, parse);

                //将读出来的读者保存到map中
                map.put(uuid,newReader);


                bufferedReader = new BufferedReader(fileReader);

                while (bufferedReader.ready()){
                    String bookLine = bufferedReader.readLine();
                    String[] strings = bookLine.split(":");
                    String bookName = strings[0];
                    String authorName = strings[1];
                    String publishDate = strings[2];
                    String returnDate = strings[3];
                    String status = strings[4];
                    boolean b = Boolean.parseBoolean(status);

                    Date parse1 = format.parse(publishDate);
                    Date returnTime = format.parse(returnDate);

                    BorrowRecord borrowRecord = new BorrowRecord(new Book(bookName, authorName, parse1, b), returnTime, returnTime);
                    borrowRecords.add(borrowRecord);

                }

                /*将读出来的书籍集合保存到reader的书籍列表中*/
                reader.setRecordList(borrowRecords);
                map.put(uuid,reader);
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }


    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }


    public Map<String, Reader> getReaderMap() {
        return readerMap;
    }

    public void setReaderMap(Map<String, Reader> readerMap) {
        this.readerMap = readerMap;
    }

    @Override
    public String toString() {
        return "LibrarySystem{" + "library=" + library + ", readerMap=" + readerMap + '}';
    }
}
