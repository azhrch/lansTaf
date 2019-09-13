package GeneratingData

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DataGenerator {

  def main(args: scala.Array[String]): Unit = {

    val path = "work/lansrodTAF"
    val date = "20171205"
    val numberOfDays = 4
    val linesNumber = 100
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val runningDay = LocalDate.parse(date, formatter)

    var i = 0

    while (i < numberOfDays) {
      val date = runningDay
        .minusDays(i)
        .toString
        .replace("-", "")

      GeneratorUtils.generateFiles(path + "/transactions_" + date , date, linesNumber)
      i += 1
    }
  }
}
