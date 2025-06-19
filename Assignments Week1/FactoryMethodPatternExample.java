import java.util.*;
import java.util.Scanner;

public class FactoryMethodPatternExample {
    public interface Document {
        public void Open();
        public void Save();
    }
    public static class wordDocument implements Document{
        @Override
        public void Open(){
            System.out.println("The Word Document is opening");
        }
        public void Save(){
            System.out.println("The Word Document is being saved");
        }
    }
    public static class pdfDocument implements Document{
        @Override
        public void Open(){
            System.out.println("The PDF Document is opening");
        }
        public void Save(){
            System.out.println("The PDF Document is being saved");
        }

    }
    public static class excelDocument implements Document{
        @Override
        public void Open(){
            System.out.println("The EXCEL Document is opening");
        }
        public void Save(){
            System.out.println("The EXCEL Document is being saved");
        }
    }
    public static abstract class DocumentFactory{
        public abstract Document createDocument();
        public void processDocument() {
            Document doc = createDocument();
            doc.Open();
            doc.Save();
        }
    }
    public static class wordDocumentFactory extends DocumentFactory{
        @Override
        public Document createDocument(){
            return new wordDocument();
        }
    }
    public static class pdfDocumentFactory extends DocumentFactory{
        @Override
        public Document createDocument(){
            return new pdfDocument();
        }
    }
    public static class excelDocumentFactory extends DocumentFactory{
        @Override
        public Document createDocument(){
            return new excelDocument();
        }
    }
    public static void main(String[] args) {
        String[] types = {"WORD", "PDF", "EXCEL", "TXT"};

        for (String type : types) {
            DocumentFactory factory;
            switch (type.toUpperCase()) {
                case "WORD":
                    factory = new wordDocumentFactory();
                    break;
                case "PDF":
                    factory = new pdfDocumentFactory();
                    break;
                case "EXCEL":
                    factory = new excelDocumentFactory();
                    break;
                default:
                    System.out.println("Unsupported document type: " + type);
                    System.out.println();
                    continue;
            }
            factory.processDocument();
            System.out.println();
        }
    }

}
