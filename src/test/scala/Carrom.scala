import com.sahaj.managers.{ControleManager, UserManager}
import com.sahaj.services.CarromBoardService

object Carrom {
  def main(args: Array[String]): Unit = {
    val carrom = new CarromBoardService()
    val player1 = UserManager.registerUser("Manju")
    val player2 = UserManager.registerUser("Manoj")

    ControleManager.promptChoices()
    carrom.strike(player1)
    carrom.strike(player2)
    var status1 = carrom.getGameStatus(player1)
    var status2 = carrom.getGameStatus(player1)
    println(status1)
    println(status2)


  }
}
