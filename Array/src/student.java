public class student {
    private String name;
    private int score;

    public student(String studentName,int studentScore){
        name=studentName;
        score=studentScore;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)",name,score);
    }

    public static void main(String[] args){
        Array<student> arr=new Array<>();
        arr.addLast(new student("Song",59));
        arr.addLast(new student("Tang",66));
        arr.addLast(new student("Wang",100));
        System.out.println(arr);
    }
}
