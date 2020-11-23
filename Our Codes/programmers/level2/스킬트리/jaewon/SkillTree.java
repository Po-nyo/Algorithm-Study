public class SkillTree {
    public static void main(String[] args){

        SkillTree result =new SkillTree();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int count =result.Count(skill,skill_trees);
        System.out.println(count);

    }
    private String Covert(String skill,String tree_i){
        String s = "";
        for(int i=0;i<tree_i.length();i++) {

            for (int j = 0; j < skill.length(); j++) {
                if(tree_i.charAt(i)==skill.charAt(j))
                    s += tree_i.charAt(i);
            }
        }
        return s;
    }

    private int Count(String skill,String[] skill_trees){
        int  count =0;
        String s;

        for(int i = 0; i<skill_trees.length;i++ ){
            s = Covert(skill,skill_trees[i]);
            boolean same = true;

            for(int j=0;j<s.length();j++){
                if(s.charAt(j)!=skill.charAt(j)){
                    same =false;
                    break;
                }
            }
            if(same == true)
                count++;
        }

        return count;
    }

}
