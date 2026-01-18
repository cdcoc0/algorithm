package programmers.level2;

/**
 * 스킬트리 (Summer/Winter Coding(~2018)
 * comment : Trie 사용 문제
 */
public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees) {
            s = s.replaceAll("[^" + skill + "]", "");
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != skill.charAt(i)) {
                    answer--;
                    break;
                }
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTree main = new SkillTree();

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(main.solution(skill, skill_trees));
    }
}
