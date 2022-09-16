import java.util.Arrays;
import java.util.Scanner;
/*▣▢■▨▩▥*/
public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello world!");
        Player player = new Player();
        player.CrPol();
        Ships.StayShip(player.a, "Player");
        Print.print(player.a);
        System.out.println("-----------------------------------------------");
        Player computer = new Player();
        computer.CrPol();
        Ships.StayShip(computer.a, "Random");
        Print.print(computer.a);
        for (int i = 0; i < 4; i++){
            computer.Shoot();
            Print.print(computer.a);
        }*/
        Player computer = new Player("Computer");
        Print.print(computer.a);
        System.out.println("____________________________");
        Print.print(computer.a);
        for (int i=0; i<20; i++) {
            computer.CompAI(computer);
            System.out.println("Был выстрел!");
        }
        Print.print(computer.a);
        System.out.println(computer.cnt_kills);
    }
}
class Player{
    String[] status;
    String type;
    String[][] a = new String[10][10];
    int cnt_kills = 0;
    public Player(String type){
        this.type = type;
        this.CrPol();
        if (this.type == "Computer"){
            status = new String[]{"random", "top", "0", "0", "0", "0"};
        }
    }
    public boolean CrPol(){
        for (int i = 0; i<this.a.length; i++){
            for (int j = 0; j<a[i].length; j++){
                this.a[i][j] = "▢";
            }
        }
        if (type == "Computer"){
            Ships.StayShip(this.a, this.type);
        }
        return true;
    }
    public Player Shoot(Player op, int x, int y){
        System.out.println("method_shoot");
        if (op.a[y][x] == "▨"){
            System.out.println(x + " " + y);
            op.a[y][x] = "▮";
            if (this.type == "Computer") {
                if (this.status[0]=="random"){
                    this.status[0] = "search";
                    this.status[2] = Integer.toString(x);
                    this.status[3] = Integer.toString(y);
                    System.out.println(Integer.parseInt(status[2]) + " " + (Integer.parseInt(status[2])+1));
                    return op;
                } else if (this.status[0]=="search") {
                    this.status[0] = "to_kill";
                    this.status[4] = Integer.toString(x);
                    this.status[5] = Integer.toString(y);
                    return op;
                }
            }
        }else if (op.a[y][x] == "▢"){
            System.out.println(x + " " + y);
            op.a[y][x] = "▣";
            if (this.type == "Computer") {
                if (this.status[0]=="search"){
                    String[] next = new String[]{"top","right","bottom","left","win"};
                    status[1] = next[Arrays.asList(next).indexOf(status[1]) + 1];
                    return op;
                } else if (this.status[0]=="to_kill"){
                    System.out.println("tokill_torev");
                    this.status[0]="to_kill_rev";
                    status[4] = Integer.toString(x);
                    status[5] = Integer.toString(y);
                    return op;
                }
            }
        }
        return op;
    }
    public String CompAI(Player op){
        int x;
        int y;
        String[] next = new String[]{"top", "right", "bottom", "left", "win"};
        String[] next_two = new String[]{"bottom", "left", "top", "right"};
        if (this.status[0] == "random"){
            while (true) {
                x = (int) (Math.random() * 9 + 1);
                y = (int) (Math.random() * 9 + 1);
                if (Ships.Proof_shoot(x, y, op.a)) {
                    break;
                }
            }
            Shoot(op, x, y);
        } else if (this.status[0] == "search") {
            System.out.println("search");
            while (true) {
                if (status[1] == "win"){
                    status = new String[]{"random", "top", "0", "0", "0", "0"};
                    cnt_kills += 1;
                    return "Корабль уничтожен";
                } else {
                    System.out.println("search_else");
                    x = Integer.parseInt(status[2]);
                    y = Integer.parseInt(status[3]);
                    int[][] n_coords = new int[][]{{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}};
                    if (Ships.Proof_shoot(n_coords[Arrays.asList(next).indexOf(status[1])][0], n_coords[Arrays.asList(next).indexOf(status[1])][1], op.a)) {
                        x = n_coords[Arrays.asList(next).indexOf(status[1])][0];
                        y = n_coords[Arrays.asList(next).indexOf(status[1])][1];
                        System.out.println("search_proof");
                        break;
                    } else {
                        status[1] = next[Arrays.asList(next).indexOf(status[1]) + 1];
                    }
                }
            }
            System.out.println("search_shoot");
            System.out.println("search_sh " + x + " " + y);
            Shoot(op, x, y);
        } else if ((this.status[0] == "to_kill")||(this.status[0]) == "to_kill_rev") {
            x = Integer.parseInt(status[4]);
            y = Integer.parseInt(status[5]);
            if (this.status[0] == "to_kill"){
                int[][] n_coords = new int[][]{{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}};
                if (Ships.Proof_shoot(n_coords[Arrays.asList(next).indexOf(status[1])][0], n_coords[Arrays.asList(next).indexOf(status[1])][1], op.a)) {
                    x = n_coords[Arrays.asList(next).indexOf(status[1])][0];
                    y = n_coords[Arrays.asList(next).indexOf(status[1])][1];
                    Shoot(op, x, y);
                } else {
                    x = Integer.parseInt(status[2]);
                    y = Integer.parseInt(status[3]);
                    n_coords = new int[][]{{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}};
                    if (Ships.Proof_shoot(n_coords[Arrays.asList(next_two).indexOf(status[1])][0], n_coords[Arrays.asList(next_two).indexOf(status[1])][1], op.a)) {
                        x = n_coords[Arrays.asList(next_two).indexOf(status[1])][0];
                        y = n_coords[Arrays.asList(next_two).indexOf(status[1])][1];
                        Shoot(op, x, y);
                        status[0] = "to_kill_rev";
                        status[4] = Integer.toString(x);
                        status[5] = Integer.toString(y);
                    } else {
                        status = new String[]{"random", "top", "0", "0", "0", "0"};
                        cnt_kills += 1;
                        return "Корабль уничтожен";
                    }
                }
            } else if (this.status[0]=="to_kill_rev") {
                x = Integer.parseInt(status[2]);
                y = Integer.parseInt(status[3]);
                int[][] n_coords = new int[][]{{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}};
                if (Ships.Proof_shoot(n_coords[Arrays.asList(next_two).indexOf(status[1])][0], n_coords[Arrays.asList(next).indexOf(status[1])][1], op.a)) {
                    x = n_coords[Arrays.asList(next_two).indexOf(status[1])][0];
                    y = n_coords[Arrays.asList(next_two).indexOf(status[1])][1];
                    Shoot(op, x, y);
                } else {
                    status = new String[]{"random", "top", "0", "0", "0", "0"};
                    cnt_kills += 1;
                    return "Корабль уничтожен";
                }
            }
        }
        return "Был выстрел!";
    }
}

class Ships{
    static String[] ships = new String[]{"▨▨▨▨","▨▨▨","▨▨▨","▨▨","▨▨","▨▨","▨","▨","▨","▨",};
    static int ori;
    static int x;
    static int y;
    static int x_last;
    static int y_last;
    static int[][] coord;
    static boolean restart;
    public static String[][] StayShip(String[][] a, String mode){
        for (int i = 0; i<ships.length; i++) {
            while (true) {
                restart = false;
                if (mode == "Computer") {
                    x = (int) (Math.random() * 8 + 1);
                    y = (int) (Math.random() * 8 + 1);
                    ori = (int) (Math.random() * 2);
                    if (ori == 0) {
                        while ((x + ships[i].length() > 10)) {
                            x = (int) (Math.random() * 8 + 1);
                        }
                    } else if (ori == 1) {
                        while ((y + ships[i].length() > 10)) {
                            y = (int) (Math.random() * 8 + 1);
                        }
                    }
                } else if (mode == "Player") {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Введите x " + ships[i].length() + "-палубного корабля: ");
                    x = in.nextInt();
                    System.out.print("Введите y " + ships[i].length() + "-палубного корабля: ");
                    y = in.nextInt();
                    if (ships[i].length() > 1) {
                        System.out.println("Введите направление корабля (1 - по вертикали, 0 - по горизонтали");
                        ori = in.nextInt();
                    } else { ori = 0; }
                }
                coord = new int[ships[i].length()][2];
                x_last = x;
                y_last = y;

                /*System.out.println(x);
                System.out.println(y);*/

                for (int j=0;j<ships[i].length();j++){
                    if (Proof(x,y,a,x_last,y_last)){
                        coord[j][0] = x;
                        coord[j][1] = y;
                        x_last = x;
                        y_last = y;
                        if (ori == 1){
                            y+=1;
                        } else if (ori == 0) {
                            x+=1;
                        }
                    } else  {
                        restart = true;
                        break;
                    }
                }
                if (restart){
                    if (mode == "Player"){System.out.println("Так нельзя поставить! Попробуйте заново!");}
                    continue;
                } else {
                    if (mode == "Player") {
                        System.out.println("Отлично! Корабль поставлен!");
                        Print.print(a);
                    }
                    Write(coord, a);
                    break;
                }

            }
        }
        return a;
    }
    public static boolean Proof_shoot(int x, int y, String[][] a){
        if (y == 10){
            return false;
        }
        if (x == 10){
            return false;
        }
        if (y == -1){
            return false;
        }
        if (x == -1){
            return false;
        }
        return (a[y][x] == "▢")||(a[y][x]=="▨");
    }

    public static boolean Proof(int x, int y, String[][] a, int x_last, int y_last){
        if (x == 9){
            --x;
        }
        if (y == 9) {
            --y;
        }
        if (x == 0) {
            ++x;
        }
        if (y == 0){
            ++y;
        }
        return (a[y][x] == "▢") & (a[y - 1][x + 1] == "▢") & (a[y][x+1] == "▢") & (a[y + 1][x + 1] == "▢") & (a[y+1][x] == "▢")
                & (a[y+1][x-1] == "▢") & (((x - 1 == x_last) & (y == y_last)) || (a[y][x-1] == "▢")) & (a[y - 1][x - 1] == "▢")
                & (((x == x_last) & (y - 1 == y_last)) || (a[y-1][x] == "▢"));
    }
    public static boolean Write(int[][]coords, String[][]a){
        for (int[] k : coords){
            a[k[1]][k[0]] = "▨";
        }
        return true;
    }

}
class Print{
    public static int print(String[][] pol){
        System.out.println("   а б в г д е ж з и к");
        for (int i = 0; i<pol.length; i++) {
            System.out.print(i + ". ");
            for (String j : pol[i]) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return 1;
    }
}