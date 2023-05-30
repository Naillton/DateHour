// Para usarmos datas e horas em java apartir da versao 8 do java usamos o time
// O calendar e o date foram descontinuados pois nao tinham muitas opcoes de tratamento
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;

public class Main {
  public static void main(String[] args) {
    // usamos aqui o Clock da biblioteca time onde usamos o systemDefaultZone
    // para conseguir retornar a data e hora com fuso horario
    Clock hour = Clock.systemDefaultZone();
    // se usarmos o print e imprimirmos so o hour recebemos o timeZone de sao paulo
    // para conseguirmos ter um horario e uma data usamos o instant() e conseguimos retornar
    // o resultado com FUSO HORARIO
    System.out.println(hour.instant());
    // com o LocalDateTime passamos o now() onde temos o resultado da hora e da data sem fuso horario
    LocalDateTime hour2 = LocalDateTime.now();
    System.out.println(hour2);
    diaDeAcad();
  }

  private static void diaDeAcad() {
    LocalDateTime work = LocalDateTime.now();
    String day = work.getDayOfWeek().toString();
    if (Objects.equals(day, "MONDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else if (Objects.equals(day, "WEDNESDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else if (Objects.equals(day, "FRIDAY")) {
      System.out.println(day+" é dia de ir para a academia");
    } else {
      System.out.println("Hoje não é dia de academia");
    }
  }
}