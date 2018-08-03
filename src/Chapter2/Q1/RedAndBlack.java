import java.util.*;

class Main {

    static char board[][] = new char[30][30];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true) {
            int w = in.nextInt();
            int h = in.nextInt();
            if (w == 0 && h == 0) {
                return;
            }
            int sx=0;
            int sy=0;
            for (int i=0; i<30; i++) {
                for(int j=0; j<30; j++) {
                    board[i][j] = '#';
                }
            }
            for (int i = 1; i <= h; i++) {
                String line = in.next();
                for(int j = 1; j <= w; j++){
                    board[i][j] = line.charAt(j-1);
                    if(board[i][j] == '@'){
                        sx = i;
                        sy = j;
                        board[i][j] = '.';
                    }
                }
            }
            dfs(sx, sy);
            int cnt = 0;
            for(int i = 1; i <= h; i++) {
                for(int j = 1; j <= w; j++) {
                    if(board[i][j] == '@') {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int i, int j){
        if(board[i][j] != '.') {
            return;
        }
        board[i][j] = '@';
        for (int k = 0; k < 4; k++) {
            dfs(i + dx[k], j + dy[k]);
        }
    }
}
