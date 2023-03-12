package ExerciseProject.TankGame;



// 爆炸类
public class Bomb {
    int X;   // 炸弹的位置
    int Y;
    int life = 6;
    boolean isLive = true;
    
    public Bomb(int x, int y) {
        X = x;
        Y = y;
    }

    public void lifeDown() {
        if (life > 0 ){
            life -= 1;
        } else {
            isLive = false;
        }
        
    }

}
