package implemented;
import java.io.*;
import java.util.StringTokenizer;


public class beakjoon5373 {
    static int T, N;
    static int[][][] cube;
    static int [][][] ans;
    // 0 : w 위/ 1: y  아래/ 2 : r 앞/ 3 : o 뒤/ 4 : g 왼 / 5 : b 오
    static int get_index(char ch){
        if(ch == 'U')
            return 0;
        if(ch == 'D')
            return 1;
        if(ch == 'F')
            return 2;    
        if(ch == 'B')
            return 3;     
        if(ch == 'L')
            return 4;
        if(ch == 'R')
            return 5;

        return 0;
    }

    static void spin(int idx, boolean mark){
        int temp[] = new int[8];
        // 0 1 2  시계  6 7 0   반   2 3 4
        // 7   3        5   1       1    5
        // 6 5 4        4 3 2       0  7 6
        temp[0] = cube[idx][0][0]; temp[1] = cube[idx][0][1];
        temp[2] = cube[idx][0][2]; temp[3] = cube[idx][1][2];
        temp[5] = cube[idx][2][1]; temp[4] = cube[idx][2][2];
        temp[6] = cube[idx][2][0]; temp[7] = cube[idx][1][0];

        if(mark){//시계방향
            cube[idx][0][0] = temp[6]; cube[idx][0][1] = temp[7]; cube[idx][0][2] = temp[0];
            cube[idx][1][0] = temp[5]; cube[idx][1][2] = temp[1];
            cube[idx][2][0] = temp[4]; cube[idx][2][1] = temp[3]; cube[idx][2][2] = temp[2];

        }
        else{
            cube[idx][0][0] = temp[2]; cube[idx][0][1] = temp[3]; cube[idx][0][2] = temp[4];
            cube[idx][1][0] = temp[1]; cube[idx][1][2] = temp[5];
            cube[idx][2][0] = temp[0]; cube[idx][2][1] = temp[7]; cube[idx][2][2] = temp[6];
        }
        
    }

    static void rotate(char ch, char direction){
        int idx = get_index(ch);
        boolean mark = direction == '+' ? true : false;
        
        spin(idx, mark);
        int []temp = new int[3];
        switch(idx){    //큐브 이동을 통일시켜야함
            case 0:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[2][0][i];
                }
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[2][0][i] = cube[5][0][i];
                        cube[5][0][i] = cube[3][0][i];
                        cube[3][0][i] = cube[4][0][i];
                        cube[4][0][i] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[2][0][i] = cube[4][0][i];
                        cube[4][0][i] = cube[3][0][i];
                        cube[3][0][i] = cube[5][0][i];
                        cube[5][0][i] = temp[i];
                    }
                }
            break;

            case 1:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[2][2][i];
                }
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[2][2][i] = cube[4][2][i];
                        cube[4][2][i] = cube[3][2][i];
                        cube[3][2][i] = cube[5][2][i];
                        cube[5][2][i] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[2][2][i] = cube[5][2][i];
                        cube[5][2][i] = cube[3][2][i];
                        cube[3][2][i] = cube[4][2][i];
                        cube[4][2][i] = temp[i];
                    }
                }
            break;

            case 2:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[0][2][2 - i];
                }
                
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[0][2][2 - i] = cube[4][i][2];
                        cube[4][i][2] = cube[1][0][i];
                        cube[1][0][i] = cube[5][2 - i][0];
                        cube[5][2 - i][0] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[0][2][i] = cube[5][i][0];
                        cube[5][i][0] = cube[1][0][2 - i];
                        cube[1][0][2 - i] = cube[4][2 - i][2];
                        cube[4][2 - i][2] = temp[2 - i];
                    }
                }
            break;

            case 3:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[0][0][i];
                }
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[0][0][i] = cube[5][i][2];
                        cube[5][i][2] = cube[1][2][2 - i];
                        cube[1][2][2 - i] = cube[4][2 - i][0];
                        cube[4][2 - i][0] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[0][0][i] = cube[4][2 - i][0];
                        cube[4][2 - i][0] = cube[1][2][2 - i];
                        cube[1][2][2 - i] = cube[5][i][2];
                        cube[5][i][2] = temp[i];
                    }
                }
                
            break;
            
            case 4:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[0][i][0];
                }
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[0][i][0] = cube[3][2 - i][2];
                        cube[3][2 - i][2] = cube[1][i][0];
                        cube[1][i][0] = cube[2][i][0];
                        cube[2][i][0] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[0][i][0] = cube[2][i][0];
                        cube[2][i][0] = cube[1][i][0];
                        cube[1][i][0] = cube[3][2 - i][2];
                        cube[3][2 - i][2] = temp[i];
                    }
                }
                
            break;

            case 5:
                for(int i = 0 ; i < 3; i++){
                    temp[i] = cube[0][i][2];
                }
                if(mark){
                    for(int i = 0 ; i < 3; i++){
                        cube[0][i][2] = cube[2][i][2];
                        cube[2][i][2] = cube[1][i][2];
                        cube[1][i][2] = cube[3][2 - i][0];
                        cube[3][2 - i][0] = temp[i];
                    }
                }
                else{
                    for(int i = 0 ; i < 3; i++){
                        cube[0][i][2] = cube[3][2 - i][0];
                        cube[3][2 - i][0] = cube[1][i][2];
                        cube[1][i][2] = cube[2][i][2];
                        cube[2][i][2] = temp[i];
                    }
                }
            break;
        }//end_switch



    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        cube = new int[6][3][3];
        ans = new int[T][3][3];
        cube_init();

        for(int round = 0; round < T; round ++){
            N = Integer.parseInt(br.readLine());

            String [] action = br.readLine().split(" ");
            for(int i = 0 ; i < N; i++){    //큐브 돌리기
                char a = action[i].charAt(0);
                char b = action[i].charAt(1);
                rotate(a,b);
            }

            for(int a= 0 ; a < 3; a++){
                for(int b= 0 ; b < 3; b++){
                    ans[round][a][b] = cube[0][a][b];
                }  
            }            
            print_cube(1);
            cube_init();    //큐브초기화

            
        }
        
        print_cube();


    }//end main
    
    static public void print_cube(){
        for(int i= 0 ; i < T; i++){
            for(int a= 0 ; a < 3; a++){
                for(int b= 0 ; b < 3; b++){
                    switch(ans[i][a][b]){
                        case 0:
                        System.out.print("w");
                        break;

                        case 1:
                        System.out.print("y");
                        break;

                        case 2:
                        System.out.print("r");
                        break;

                        case 3:
                        System.out.print("o");
                        break;

                        case 4:
                        System.out.print("g");
                        break;

                        case 5:
                        System.out.print("b");
                        break;
                    }

                }  
                System.out.println();
            } 
        }
    }// end function
    static public void cube_init(){
        for(int i= 0 ; i < 6; i++){
            for(int a= 0 ; a < 3; a++){
                for(int b= 0 ; b < 3; b++){
                    cube[i][a][b] = i;
                }
            } 
        }
    }// end function
    static public void print_cube(int idx){
        for(int a= 0 ; a < 3; a++){
            for(int b= 0 ; b < 3; b++){
                System.out.print(cube[idx][a][b] + " ");
            }
            System.out.println();
        } 
    }//end_print_cube
}
