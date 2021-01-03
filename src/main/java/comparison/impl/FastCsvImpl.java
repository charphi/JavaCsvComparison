package comparison.impl;

import java.util.List;
import java.util.stream.Collectors;

import de.siegmar.fastcsv.reader.CsvReader;

public class FastCsvImpl implements CsvImpl {

    @Override
    public String getName() {
        return "FastCSV";
    }

    @Override
    public List<String[]> readCsv(final String data, final boolean skipEmptyRows) {
        return CsvReader.builder().skipEmptyRows(skipEmptyRows)
            .build(data).stream()
            .map(row -> row.getFields().toArray(new String[0]))
            .collect(Collectors.toList());
    }

}
