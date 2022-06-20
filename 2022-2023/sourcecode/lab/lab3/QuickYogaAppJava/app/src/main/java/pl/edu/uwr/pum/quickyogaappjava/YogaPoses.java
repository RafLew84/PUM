package pl.edu.uwr.pum.quickyogaappjava;

import java.util.ArrayList;

public final class YogaPoses {
    private YogaPoses(){}

    public static ArrayList<YogaPose> getYogaPoses(){
        int[] images = {
                R.drawable.e1w,
                R.drawable.e2w,
                R.drawable.e3w,
                R.drawable.e4w,
                R.drawable.e5w,
                R.drawable.e6w,
                R.drawable.e7w,
                R.drawable.e8w,
                R.drawable.e9w,
                R.drawable.e10w,
                R.drawable.e11w,
                R.drawable.e12w,
        };

        String[] names = {"Cobra", "Lord of the Dance", "Low Lunge", "Dancer",
                "Wide Leg Forward Bend", "Warrior", "Lord Of The Dance Full",
                "Squatting Toe Balance", "Lord Of The Dance Revolved",
                "Wheel, One Legged", "Shoulder Stand, Split", "Warrior, Reverse"};

        ArrayList<YogaPose> yogaPoses = new ArrayList<>(12);
        for(int i = 0; i < 12; i++){
            yogaPoses.add(
                    new YogaPose(
                            i,
                            names[i],
                            images[i]
                    )
            );
        }
        return yogaPoses;
    }
}
