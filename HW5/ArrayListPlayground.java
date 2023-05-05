package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
    // Question 1
    // Write Java statements that do the following:

    // a) Declare an arrayList nums of 15 elements of type int.

    ArrayList<Integer> nums = new ArrayList<Integer>(15);
    nums.add(1);
    nums.add(2);
    nums.add(3);
    nums.add(4);
    nums.add(5);
    nums.add(6);
    nums.add(7);
    nums.add(8);
    nums.add(9);
    nums.add(10);
    nums.add(11);
    nums.add(12);
    nums.add(13);
    nums.add(14);
    nums.add(15);

    // b) Output the value of the tenth element of the array nums.
   
    System.out.println(nums.get(9));

    // c) Set the value of the 5th element of the array nums to 99.

    nums.set(4, 99);

    // d) set the value of the 13th element to 15

    nums.set(12, 15);
    
    // e) set the value of the 2nd element to 6
    
    nums.set(1, 6);
    
    // f) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.
    
    nums.set(8, nums.get(12) + nums.get(1));
    

         
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)

    ArrayList<String> days = new ArrayList<String>(7);
    days.add("Monday");
    days.add("Tuesday");
    days.add("Wednesday");
    days.add("Thursday");
    days.add("Friday");
    days.add("Saturday");
    days.add("Sunday");
    
    // b) output each of the days of the week

    System.out.println(days);
    
    // c) output the days of the week that we have class 

    System.out.println(days.get(1));
    System.out.println(days.get(3));
    
    // d) change the arrayList to start on Sunday
days.set(0, "Sunday");
days.set(1, "Monday");
days.set(2, "Tuesday");
days.set(3, "Wednesday");
days.set(4, "Thursday");
days.set(5, "Friday");
days.set(6, "Saturday");


    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected

    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Scanner input = new Scanner(System.in);
    int num = 1;
    while (num != 0){
        System.out.print("Number: ");
        num = input.nextInt();
        numbers.add(num);
    }

    // b) return the largest and smallest number

    int largest = numbers.get(0);
    int smallest = numbers.get(0);
    for (int i = 0; i < numbers.size(); i++){
        if (numbers.get(i) > largest){
            largest = numbers.get(i);
        }
        if (numbers.get(i) < smallest){
            smallest = numbers.get(i);
        }
    }
    System.out.println("Largest: " + largest);
    System.out.println("Smallest: " + smallest);
    // c) return the ArrayList sorted smallest to largest

    Collections.sort(numbers);
    System.out.println(numbers);

    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format

    if (numbers.size()%3==0){
        for(int i=0;i<numbers.size();i++)
        {
            System.out.print(numbers.get(i)+" ");
            if((i+1)%3==0)
            {
                System.out.println();
            }
        }
    } 
    else if (numbers.size()%3==1){
        System.out.println("Please enter 2 more numbers to create the matrix...");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        numbers.add(num1);
        numbers.add(num2);
        for(int i=0;i<numbers.size();i++)
        {
            System.out.print(numbers.get(i)+" ");
            if((i+1)%3==0)
            {
                System.out.println();
            }
        } 
    }
    else{
        System.out.println("Please enter 1 more number to create the matrix...");
        int num1 = input.nextInt();
        numbers.add(num1);
        for(int i=0;i<numbers.size();i++)
        {
            System.out.print(numbers.get(i)+" ");
            if((i+1)%3==0)
            {
                System.out.println();
            }
        } 
    }
    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }


        
  

}
}




   

