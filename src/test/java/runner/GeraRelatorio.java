package runner;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeraRelatorio {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private static DateFormat dateFormatFile = new SimpleDateFormat("dd-M-yyyy");
    private static Date date = new Date();

    public static void gerar(){
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setReportDirectory("target/report/");
        reportBuilder.setReportFileName(dateFormatFile.format(date));
        reportBuilder.setReportTitle("Relatorio de Execucao");
        reportBuilder.setReportColor(Color.CYAN);
        reportBuilder.enableVoiceControl();
        reportBuilder.setAdditionalInfo("Environment", "My Environment");
        reportBuilder.setAdditionalInfo("Date", dateFormatFile.format(date));
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("target/report/cucumber.json"));
        reportBuilder.build(cucumberJsonReports);
    }

    public static void main(String[] args) {
        GeraRelatorio gerarRelatorio = new GeraRelatorio();
        gerarRelatorio.gerar();
    }
}
