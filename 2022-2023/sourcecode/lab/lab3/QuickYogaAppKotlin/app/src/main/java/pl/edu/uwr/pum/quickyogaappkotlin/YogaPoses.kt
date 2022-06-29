package pl.edu.uwr.pum.quickyogaappkotlin

object YogaPoses {
    val yogaPoses: ArrayList<YogaPose>
        get() {
            val images = intArrayOf(
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
                R.drawable.e12w
            )
            val names = arrayOf(
                "Cobra", "Lord of the Dance", "Low Lunge", "Dancer",
                "Wide Leg Forward Bend", "Warrior", "Lord Of The Dance Full",
                "Squatting Toe Balance", "Lord Of The Dance Revolved",
                "Wheel, One Legged", "Shoulder Stand, Split", "Warrior, Reverse"
            )
            val yogaPoses: ArrayList<YogaPose> = ArrayList(12)
            for (i in 0..11) {
                yogaPoses.add(
                    YogaPose(
                        i,
                        names[i],
                        images[i]
                    )
                )
            }
            return yogaPoses
        }
}