public class Main {
    public static void main(String[] args) {
        Reader Ivanov = new Reader("Иванов А. Г.", 1111111, "Прикладная информатика", "01.03.2000",
                "+7(999)123-45-67");

        Book dict = new Book("Словарь", "Даль");
        Book ency = new Book("Энциклопедия", "Кинг");
        Book Robi = new Book("Робинзон Крузо", "Дефо");

        Ivanov.takeBook(4);
        Ivanov.takeBook("Энциклопедия", "Словарь", "Робинзон Крузо");
        Ivanov.takeBook(dict, ency, Robi);

        System.out.println();

        Ivanov.returnBook(2);
        Ivanov.returnBook("Словарь");
        Ivanov.returnBook(Robi);

    }
}

class Reader{
    String name;
    int ticket;
    String faculty;
    String date_birth;
    String phone_number;
    public Reader(String name, int ticket, String faculty, String date_birth, String phone_number){
        this.name = name;
        this.ticket = ticket;
        this.faculty = faculty;
        this.date_birth = date_birth;
        this.phone_number = phone_number;
    }
    public void takeBook(int count){
        System.out.println(name + " взял " + count + " книги");
    }
    public void takeBook(String... names){
        String answer = name + " взял книги: ";
        for(String i: names){
            answer += i + ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2));
    }
    public void takeBook(Book... names){
        String answer = name + " взял книги: ";
        for(Book i: names){
            answer += i.name + ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2));
    }
    public void returnBook(int count){
        System.out.println(name + " вернул " + count + " книги");
    }
    public void returnBook(String... names){
        String answer = name + " вернул книги: ";
        for(String i: names){
            answer += i + ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2));
    }
    public void returnBook(Book... names){
        String answer = name + " вернул книги: ";
        for(Book i: names){
            answer += i.name + ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2));
    }
}

class Book{
    String name;
    String author;
    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }
}