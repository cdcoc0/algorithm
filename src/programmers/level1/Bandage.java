package programmers.level1;

/* 붕대 감기 */
public class Bandage {
    private static int solution(int[] bandage, int health, int[][] attacks) {
        int len = attacks.length;
        int lastAttack = attacks[len - 1][0];
        int ptrAttack = 0;
        int curHealth = health;
        int cntConsecutive = 0;

        for(int i = 1; i <= lastAttack; i++) {
            if(i == attacks[ptrAttack][0]) {
                curHealth -= attacks[ptrAttack][1];

                if(curHealth <= 0) {
                    return -1;
                }

                cntConsecutive = 0;
                ptrAttack++;
            } else {
                curHealth = Math.min(health, curHealth + bandage[1]);
                cntConsecutive++;

                if(cntConsecutive == bandage[0]) {
                    curHealth = Math.min(health, curHealth + bandage[2]);
                    cntConsecutive = 0;
                }
            }
        }

        return curHealth;
    }

    public static void main(String[] args) {
        int[] bandage = {2, 4, 4};
        int health = 100;
        int[][] attacks = {{1, 96}, {18, 1}};
        //99

        solution(bandage, health, attacks);
    }
}
