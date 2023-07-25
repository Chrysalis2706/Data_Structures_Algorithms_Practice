package Greedy_Algorithm_Problems;

import java.util.ArrayList;
import java.util.Collections;

public class Job_Sequencing_Problem {

    static class Jobs{
        static int id;
        static int deadline;
        static int profit;
        public Jobs(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {
                {4,20},
                {1,10},
                {1,40},
                {1,30}
        };

        int ans = jobSequencingSol(jobsInfo);
        System.out.println(ans);
    }

    public static int jobSequencingSol(int[][] jobsInfo) {
        int ans  = 0;
        ArrayList<Jobs> job = new ArrayList<>();

        // create object of new arraylist Jobs
        for (int i=0; i<jobsInfo.length; i++){
            job.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sorting according to the object
        Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order

        //greedy about profit
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i=0; i<job.size(); i++){
            Jobs currObj = job.get(i);
            if (currObj.deadline > time){
                seq.add(currObj.id);
                time += 1;
                ans += currObj.profit;
            }
        }

        for (int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " -> ");
        }
        System.out.println("end");
        return ans;
    }
}
