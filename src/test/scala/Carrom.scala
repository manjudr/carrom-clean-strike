import com.sahaj.managers.{Choices, DashBoardManager, UserManager}
import com.sahaj.services.CarromBoardService

object Carrom {
  def main(args: Array[String]): Unit = {
    val carrom = new CarromBoardService()

    val player1 = UserManager.registerUser("Manju")
    val player2 = UserManager.registerUser("Manoj")
    while (!carrom.isMatchWon) {
      val activePlayer = if (player1.status == "ACTIVE") {
        player2.restStatus("ACTIVE")
        player1
      } else {
        player1.restStatus("ACTIVE")
        player2
      }
      val response: Choices = DashBoardManager.promptChoices(activePlayer)
      if (response.number != 7) {
        carrom.hit(response, activePlayer)
        carrom.showScoreBoard(activePlayer)
      } else {
        println("Closing..")
        System.exit(0)
      }
    }
  }
}
