package GeneratingData


import java.text.SimpleDateFormat
import java.util.{Date, Random}

import org.apache.spark.sql.SparkSession

object GeneratorUtils {

  val spark = SparkSession.
    builder.master("local[*]")
    .appName("data generator App")
    .getOrCreate()

  import spark.sqlContext.implicits._



  private val ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvxyzw0123456789"

  /** Générer un alphanumérique aléatoire
    *
    * @param length La longueur de l'alphanumérique
    * @return un alphanumérique aléatoire de longeur length
    */
  def randomAlphaNumeric(length: Int): String = {
    val builder = new StringBuilder
    var i = 0
    while (i < length) {
      i += 1
      val character = (Math.random * ALPHA_NUMERIC_STRING.length).toInt
      builder.append(ALPHA_NUMERIC_STRING.charAt(character))
    }
    builder.toString
  }


  /** Générer un id magasin alphanumérique aléatoire.
    */
  def generateRandomIdMagasin: String = {
    randomAlphaNumeric(8) + "-" +
      randomAlphaNumeric(5) + "-" +
      randomAlphaNumeric(4) + "-" +
      randomAlphaNumeric(4) + "-" +
      randomAlphaNumeric(12)
  }

  /** Générer une date aléatoire
    *
    * @param n une valeur utilisée pour changer la date
    * @return une date aléatoire
    */
  def generateRandomDate(n: Int): String = {
    val simple = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ")
    val result = new Date(System.currentTimeMillis + n * 5445)
    simple.format(result)
  }



  /** Générer un fichier de transactions
    *
    * @param path        la destination du fichier
    * @param date        la date des transactions
    * @param linesNumber le nombre des lignes dans le fichier
    *
    */

  def generateFiles(path: String, date: String, linesNumber: Int) {

    var i = 0
    var list = List[(String, Int, Int, String, Int)]()

    while (i < linesNumber) {
      val rand = new Random
      val transId = Math.abs(rand.nextInt(100))
      val n = Math.abs(rand.nextInt(100))
      val randomTime = generateRandomDate(n)
      val datetime = date + randomTime.substring(8, randomTime.toString.length)
      val magasinId = generateRandomIdMagasin
      val produitId = Math.abs(rand.nextInt(100))
      val qte = Math.abs(rand.nextInt(100))



     list = list ++ List((datetime, produitId, transId, magasinId, qte))


      i += 1
    }
    val df = list.toDF("date", "produitID", "transID", "magasinID", "qte")
    df.foreach(x => println(x(0)))
    df.write.parquet("hdfs://127.0.0.1:8020/"+path)

  }


  def kafkaProducer(path: String, date: String, linesNumber: Int) {

    var i = 0
    while (i < linesNumber) {
      val rand = new Random

      val produitId = Math.abs(rand.nextInt(100))
      val prix = "%05.2f".format(rand.nextFloat * 100) + "".substring(0, 5)
      val qte = Math.abs(rand.nextInt(100))
      val magasinId = generateRandomIdMagasin





    }


  }

















}
