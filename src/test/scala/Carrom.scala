import com.sahaj.managers.{Choices, ControleManager, UserManager}
import com.sahaj.services.CarromBoardService

object Carrom {
  def main(args: Array[String]): Unit = {
    val carrom = new CarromBoardService()

    val player1 = UserManager.registerUser("Manju")
    val player2 = UserManager.registerUser("Manoj")

    val promptFor = if (player1.status == "ACTIVE") player1 else player2

    while (promptFor.wonStatus != "WON") {
      val response: Choices = ControleManager.promptChoices(promptFor)
      if (response.number != 7) {
        carrom.hit(response, player1)
        carrom.showScoreBoard(player1)
      } else {
        println("Closing..")
        System.exit(1)
      }
    }
  }
}
