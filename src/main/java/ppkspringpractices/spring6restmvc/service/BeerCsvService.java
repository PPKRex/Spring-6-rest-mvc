package ppkspringpractices.spring6restmvc.service;

import com.opencsv.bean.CsvToBeanBuilder;
import ppkspringpractices.spring6restmvc.dto.BeerCSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
