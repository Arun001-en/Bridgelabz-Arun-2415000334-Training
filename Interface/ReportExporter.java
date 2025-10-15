public interface ReportExporter {
    void exportToCSV(String reportData);
    void exportToPDF(String reportData);

    // New default method for JSON export
    default void exportToJSON(String reportData) {
        // Simple stub: In real cases, use a library like Jackson or Gson
        System.out.println("JSON export not supported by this exporter.");
    }
}
