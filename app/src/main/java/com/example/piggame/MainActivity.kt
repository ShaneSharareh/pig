package com.example.piggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val player1 =  Player(1, 0)
    val player2 = Player(1, 0);
    val playerTurn = ArrayList<Player>()
    var turnNumber: Int = 0;
    val dice = Dice();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerTurn.add(player1);
        playerTurn.add(player2);
        checkStatus()
        btn_roll_dice.setOnClickListener(this)
        btn_hold.setOnClickListener(this)
        tv_firstPlayerScore.setText("0")
        tv_secondPlayerScore.setText("0")

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_roll_dice ->{
                //check status
                checkStatus();
                //Roll Dice
                var diceValue = rollDice()
                //set score of player
                if(diceValue!=1){
                    playerTurn[turnNumber].score += diceValue;
                    displayScore();
                    checkIfWinner();
                }
                else{
                    playerTurn[turnNumber].score = 0;
                    diceValue = 0;
                    displayScore();
                    nextPlayer();
                    checkStatus()
                }
            }

            R.id.btn_hold ->{
                nextPlayer();
                checkStatus();
            }
        }    }

    fun rollDice():Int{
        var dieFaceImage:Int = 0;
        val diceValue = (Math.floor(Math.random()*6) +1).toInt()
        dieFaceImage = dice.getFaceImage(diceValue)
        iv_die_face.setImageResource(dieFaceImage);
        return diceValue;
    }

    fun displayScore(){
        when(turnNumber) {
            0 -> tv_firstPlayerScore.setText("" + playerTurn[0].score)
            1 -> tv_secondPlayerScore.setText(""+ playerTurn[1].score)
        }

    }

    fun nextPlayer(){
        when(turnNumber) {
            0 -> turnNumber = 1
            1 -> turnNumber = 0
        }
        }

    fun checkStatus(){
        when(turnNumber) {
            0 -> {
                  tv_firstPlayer.setText("* Player 1")
                  tv_secondPlayer.setText("Player 2")

            }
            1 -> {
                tv_secondPlayer.setText("* Player 2")
                tv_firstPlayer.setText("Player 1")
            }
        }
    }

    fun checkIfWinner(){
        if(playerTurn[0].score >= 100){
            tv_firstPlayer.setText("Winner: Player 1")
        }
        else if (playerTurn[0].score>=100){
            tv_secondPlayer.setText("Winner: Player 2")

        }
    }

    }


