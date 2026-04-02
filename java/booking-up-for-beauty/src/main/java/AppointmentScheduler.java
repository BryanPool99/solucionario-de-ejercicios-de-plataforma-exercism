import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        // 1. Definimos el formato que tiene el String de entrada
        // MM = mes, dd = día, yyyy = año, HH = hora (0-23), mm = minutos, ss = segundos
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        // 2. Convertimos el String a LocalDateTime usando ese formato
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime now = LocalDateTime.now();
        return appointmentDate.isBefore(now);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        //Extraemos solo la hora de la fecha completa
        LocalTime hourAttention = appointmentDate.toLocalTime();
        //Definimos nuestos limites
        LocalTime startAfternoon = LocalTime.of(12, 0, 0);
        LocalTime endAfternoon = LocalTime.of(17, 59, 59);
        //Validamos si se encuentra en ese rango
        boolean isEarly = hourAttention.isBefore(startAfternoon);
        boolean isLate = hourAttention.isAfter(endAfternoon);
        //retornamos que no sea temprano ni sea tarde con respcto al horrio de la tarde
        return !isEarly && !isLate;
        //otra forma
        /*
        int hour = appointmentDate.getHour();
        return hour >=12 && hour <18;
         */
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter parser = DateTimeFormatter
                .ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a.", java.util.Locale.ENGLISH);
        return String.format(
                "You have an appointment on %s", parser.format(appointmentDate)
        );
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
