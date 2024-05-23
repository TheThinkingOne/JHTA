public class GameMethod {
    private int MaxSize = 20;
    private int[][] Map;
    private int GamePlay_cnt;
    private int cun_GamePlayer;

    public GameMethod() {
        this.Map = new int[this.MaxSize][this.MaxSize];
        this.GamePlay_cnt = 2;
        this.cun_GamePlayer = 1;
    }

    public void init() {
        for(int i = 0; i < this.MaxSize; ++i) {
            for(int j = 0; j < this.MaxSize; ++j) {
                this.Map[i][j] = 0;
            }
        }

    }

    public void nextPlayer(int cun_p) {
        ++cun_p;
        if (this.GamePlay_cnt < cun_p) {
            this.cun_GamePlayer = 1;
        } else {
            this.cun_GamePlayer = cun_p;
        }

    }

    public boolean endGame(Word w) {
        int nowColor = w.getColor();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

        for(int i = 0; i < 8; i += 2) {
            int same_cnt = 1;
            int cunY = w.getY();
            int cunX = w.getX();

            int j;
            for(j = 0; j < 5; ++j) {
                cunY += dir[i][0];
                cunX += dir[i][1];
                if (cunY < 0 || cunY >= this.MaxSize || cunX < 0 || cunX >= this.MaxSize || nowColor != this.Map[cunY][cunX]) {
                    break;
                }

                ++same_cnt;
            }

            cunY = w.getY();
            cunX = w.getX();

            for(j = 0; j < 5; ++j) {
                cunY += dir[i + 1][0];
                cunX += dir[i + 1][1];
                if (cunY < 0 || cunY >= this.MaxSize || cunX < 0 || cunX >= this.MaxSize || nowColor != this.Map[cunY][cunX]) {
                    break;
                }

                ++same_cnt;
            }

            if (same_cnt >= 5) {
                return true;
            }
        }

        return false;
    }

    public void inputWord(Word w) {
        this.Map[w.getY()][w.getX()] = w.getColor();
    }

    public boolean checkInput(int y, int x) {
        return this.Map[y][x] == 0 && y >= 0 && y < this.MaxSize && x >= 0 && x < this.MaxSize;
    }

    public void setGameMode(int max) {
        this.GamePlay_cnt = max;
    }

    public int[][] getMap() {
        return this.Map;
    }

    public int getCun_GamePlayer() {
        return this.cun_GamePlayer;
    }
}
