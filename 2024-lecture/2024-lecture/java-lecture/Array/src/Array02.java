public class Array02 {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        String animals[] = {"dog","cat","lion","Trex"};
        enum Day {sun,mon,tue,wed,thu,fri,sat}; // 열거형


        for (int i=0; i<nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
        System.out.println();
        for (int el : nums) {
            System.out.println(el + " ");
        }
        for (String el : animals) {
            System.out.println(el + " ");
        }
        for(Day day : Day.values()) {
            System.out.print(day+"\t");
        }

        int intArr[][] = new int[3][2];
        intArr[0][0] = 10;
        intArr[0][1] = 20;
        intArr[1][0] = 30;
        intArr[1][1] = 40;
        intArr[2][0] = 50;
        intArr[2][1] = 60;
        int intArr02[][] = {{10,20},{30,40},{50,60}};
    }
}
