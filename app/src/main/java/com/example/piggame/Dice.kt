package com.example.piggame

class Dice (){

        val dieFaceImage1 = R.drawable.die_face_1
        val dieFaceImage2 = R.drawable.die_face_2
        val dieFaceImage3 = R.drawable.die_face_3
        val dieFaceImage4 = R.drawable.die_face_4
        val dieFaceImage5 = R.drawable.die_face_5
        val dieFaceImage6 = R.drawable.die_face_6

        fun getFaceImage(faceValue: Int):Int{
                var diceImage:Int = 0;
                when(faceValue){
                        1 -> diceImage = dieFaceImage1
                        2 -> diceImage = dieFaceImage2
                        3 -> diceImage = dieFaceImage3
                        4 -> diceImage = dieFaceImage4
                        5 -> diceImage = dieFaceImage5
                        6 -> diceImage = dieFaceImage6

                }
                return  diceImage
        }
    }


