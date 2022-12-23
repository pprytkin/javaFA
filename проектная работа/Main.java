import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Zadachi> z = new ArrayList<>(); //Список с добавленными задачами
        System.out.println("Список команд:\nnew - новая задача\ndel - удалить задачу\nedit - редактировать задачу");
        System.out.println("all (done/active) (date to/date create) - вывести все задачи (выполненные/нет) (по дате выполнения/создания)");
        System.out.println("open - открыть задачу\ndone - отметить, как выполненную");
        while (true){ //Программа запрашивает команды от пользователя
            Scanner sc = new Scanner(System.in);
            System.out.println("Что Вы хотели бы сделать?");
            String o = sc.nextLine();
            if (Objects.equals(o, "new")){ //Команда "new" - добавление новой задачи
                Oper.add(z);
            } else if (Objects.equals(o, "all")) {//Команда "all" - отображение всех задач
                Oper.print(z, "None");
            } else if (Objects.equals(o, "all active")) {//Команда "all active" - отображение всех невыполненных задач
                Oper.print(z, "active");
            } else if (Objects.equals(o, "all done")) {//Команда "all done" - отображение всех выполненных задач
                Oper.print(z, "done");
            } else if (Objects.equals(o, "del")) {//Команда "del" - удаление задачи
                Oper.delete(z);
            } else if (Objects.equals(o, "edit")) {//Команда "edit" - редактирование задачи
                Oper.edit(z);
            } else if (Objects.equals(o, "all date to")){//Команда "all date to" - отображение всех задач на отпределенную дату выполнения
                Oper.print_date_to(z, "None");
            } else if (Objects.equals(o, "all active date to")){//Команда "all active date to" - отображение всех невыполненных задач на отпределенную дату выполнения
                Oper.print_date_to(z, "active");
            } else if (Objects.equals(o, "all done date to")){//Команда "all done date to" - отображение всех выполненных задач на отпределенную дату выполнения
                Oper.print_date_to(z, "done");
            } else if (Objects.equals(o, "all date create")){//Команда "all date create" - отображение всех задач на отпределенную дату создания
                Oper.print_date_create(z, "None");
            } else if (Objects.equals(o, "all active date create")) {//Команда "all active date create" - отображение всех невыполненных задач на отпределенную дату создания
                Oper.print_date_create(z, "active");
            } else if (Objects.equals(o, "all done date create")) {//Команда "all done date create" - отображение всех выполненных задач на отпределенную дату создания
                Oper.print_date_create(z, "done");
            } else if (Objects.equals(o, "open")){//Команда "open" - открытие задачи
                Oper.open(z);
            } else if (Objects.equals(o, "done")){//Команда "done" - отметить задачу, как выполненную
                Oper.done(z);
            }
        }
    }
}

//Класс задач
class Zadachi{
    int number;//Номер задачи
    String name;//Название задачи
    String desc;//Описание задачи
    LocalDate date_create;//Дата создания
    LocalDate date_to;//Дата выполнения
    String status;//Статус (выполненная/невыполненная)
    public Zadachi(String name, String desc, LocalDate to, int number){
        this.name = name;
        this.desc = desc;
        this.date_create = LocalDate.now();
        this.date_to = to;
        this.number = number;
        this.status = "active";
    }
}
//Класс с операциями над задачами
class Oper{
    //Добавление новой  задачи
    public static void add(List<Zadachi> z){//На вход передаётся список задач
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название задачи:");
        String name = sc.nextLine();
        System.out.println("Введите описание задачи:");
        String desc = sc.nextLine();
        System.out.println("Введите дату окончания задачи (в формате 'День Месяц Год':");
        LocalDate to = add_date(sc.nextLine());
        Zadachi z1 = new Zadachi(name, desc, to, z.size() + 1);
        z.add(z1);//Добавление задачи в список задач
    }
    //Удаление задачи
    public static void delete(List<Zadachi> z){//На вход передаётся список задач
        Scanner sc = new Scanner(System.in);
        System.out.println("Какое задание Вы хотели бы удалить? (Введите его номер)");
        int number = sc.nextInt();
        z.remove(number - 1);
        for (int i = number - 1; i < z.size(); i ++){
            z.get(i).number = i + 1;//Присваивание задачам с номерами больше удаленного новых номеров (на 1 меньше)
        }
    }
    //Редактирование задачи
    public static void edit(List<Zadachi> z){//На вход передаётся список задач
        Scanner sc = new Scanner(System.in);
        System.out.println("Какое задание Вы хотели бы оредактировать?");
        int number = sc.nextInt() - 1;
        System.out.println("Что Вы хотели бы отредактировать?\n1 - Название\n2 - Описание\n3 - Дату выполнения");
        int o = sc.nextInt();
        sc = new Scanner(System.in);
        if (o == 1){
            System.out.println("Введите новое название задания:");
            z.get(number).name = sc.nextLine();
        } else if (o == 2) {
            System.out.println("Введите новое описания задания:");
            z.get(number).desc = sc.nextLine();
        } else if (o == 3) {
            System.out.println("Введите новую дату выполнения задания (в формате 'день месяц год'):");
            z.get(number).date_to = add_date(sc.nextLine());
        }
    }
    //Форматирование задачи из строки в LocalDate
    public static LocalDate add_date(String date){//На вход передаётся строка с датой
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");//Форматтер с паттерном
        return LocalDate.parse(date, formatter);//возвращает LocalDate
    }
    //Вывод всех задач
    public static void print(List<Zadachi> z, String status){
        if (z.size() > 0){
            for (Zadachi z1 : z){
                if (Objects.equals(status, "None")){//Если передаваемый из команды статус == "None"
                    System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся все задачи
                } else {//Иначе
                    if (Objects.equals(z1.status, status)){
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся задачи с передаваемым статусом (выполненные или нет)
                    }
                }
            }
        } else {//Если список задач пуст
            System.out.println("Задач ещё нет");
        }
    }
    //Вывод задач по дате выполнения
    public static void print_date_to(List<Zadachi> z, String status){//На вход передаются список задач и статус для поиска
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату выполнения задачи (в формате 'день месяц год')");
        LocalDate date = add_date(sc.nextLine());
        if (z.size() > 0){
            for (Zadachi z1 : z){
                if (z1.date_to.isEqual(date)) {
                    if (Objects.equals(status, "None")) {//Если передаваемый из команды статус == "None"
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся все задачи
                    } else {
                        if (Objects.equals(z1.status, status)){
                            System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся задачи с передаваемым статусом (выполненные или нет)
                        }
                    }
                }
            }
        } else {//Если список задач пуст
            System.out.println("Задач ещё нет");
        }
    }
    //Вывод задач по дате создания
    public static void print_date_create(List<Zadachi> z, String status){//На вход передаются список задач и статус для поиска
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату создания задачи (в формате 'день месяц год')");
        LocalDate date = add_date(sc.nextLine());
        if (z.size() > 0){
            for (Zadachi z1 : z){
                if (z1.date_create.isEqual(date)) {
                    if (Objects.equals(status, "None")) {//Если передаваемый из команды статус == "None"
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся все задачи
                    } else {
                        if (Objects.equals(z1.status, status)){
                            System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);//Выводятся задачи с передаваемым статусом (выполненные или нет)
                        }
                    }
                }
            }
        } else {//Если список задач пуст
            System.out.println("Задач ещё нет");
        }
    }
    //Отметить задачу, как выполненную
    public static void done(List<Zadachi> z){//На вход передаётся список задач
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выполненное задание (номер):");
        int number = sc.nextInt() - 1;
        z.get(number).status = "done";//У задачи меняется статус с "active" на "done"
    }
    //Открытие задачи
    public static void open(List<Zadachi> z){//На вход передаётся список задач
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задания:");
        int number = sc.nextInt() - 1;
        //Построчно выводятся: номер, название, описание, дата выполнения, дата создания
        System.out.println("Номер: " + z.get(number).number);
        System.out.println("Название: " + z.get(number).name);
        System.out.println("Описание: " + z.get(number).desc);
        System.out.println("Выполнить до " + z.get(number).date_to);
        System.out.println("Задание создано " + z.get(number).date_create);
        //Если задание выполненно, то выводится соответственное сообщение
        if (Objects.equals(z.get(number).status, "done")){
            System.out.println("Задание выполненно!");
        }
    }
}