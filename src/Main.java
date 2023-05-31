// Para usarmos datas e horas em java apartir da versao 8 do java usamos o time
// O calendar e o date foram descontinuados pois nao tinham muitas opcoes de tratamento e usamos o LocalDateTime
// tambem podemos usar so uma opcao para hora e data, usaremos LocalTime e LocalDate para cada uma das especificacoes
import java.time.Clock;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.text.DateFormatter;

public class Main {
  static LocalTime tempo;
  static LocalDate data;
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
    Scanner sc = new Scanner(System.in);
    System.out.println("Informe o a data do evento no formato ano-mes-dia e o horario do evento");
    String eventDate = sc.nextLine();
    String eventTime = sc.nextLine();
    agendarEvento(eventDate, eventTime);
    checkEvent();
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

  private static void agendarEvento(String d, String h) {
    // usando o parse para transformar o texto recebido em LocalDate e LocalTime
    data = LocalDate.parse(d);
    System.out.println(d);
    tempo = LocalTime.parse(h);
    System.out.println(h);
  }

  private static void checkEvent() {
    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);
    LocalTime horaHoje = LocalTime.now();
    System.out.println(horaHoje);
    // transformando a data recebida no formato BR
    String formatDate = "dd/MM/yyyy";
    DateTimeFormatter formatedData = DateTimeFormatter.ofPattern(formatDate);
    if (data.equals(hoje)) {
      if (tempo.isAfter(horaHoje)) {
        System.out.println("O evento está rolando ou já acabou, verifique!");
      } else if(tempo.isBefore(horaHoje)) {
        System.out.println("O horario do evento está chegando não se atrase");
      } else {
        System.out.println("Hora do EVENTOOOOOOOOO!!!");
      }
    } else if(data.isAfter(hoje)) {
      System.out.println("O evento é na data "+formatedData.format(data)+" se prepare!!");
    } else {
      System.out.println("O evento já passou! preste atenção em suas datas");
    }

  }
}