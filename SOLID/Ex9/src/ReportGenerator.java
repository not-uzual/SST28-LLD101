public interface ReportGenerator {
    String write(Submission s, int plagScore, int codeScore);
}
