import com.sahaj.managers.{Choices, DashBoardManager, PlayerManager}
import com.sahaj.services.CarromBoardService

object Carrom {
  def main(args: Array[String]): Unit = {
    val carrom = new CarromBoardService()
    val player1 = PlayerManager.registerUser("Manju")
    val player2 = PlayerManager.registerUser("Manoj")
    PlayerManager.play(player1, player1, carrom)
  }
}
