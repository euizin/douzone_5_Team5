package CourseRegister.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class FileIO {
    private FileInputStream fis;
    private FileOutputStream fos;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    // 생성자
    public FileIO(String filePath) {
        try {
            // 파일 입력 스트림
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);

            // 파일 출력 스트림
            fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);

            // 객체 입력 스트림
            ois = new ObjectInputStream(bis);

            // 객체 출력 스트림
            oos = new ObjectOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 문자열을 읽어서 반환하는 메서드
    public String readTextFile() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // 문자열을 파일에 쓰는 메서드
    public void writeTextFile(String contents) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(bos));
        try {
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 객체를 읽어서 반환하는 메서드
    public Object readObjectFile() {
        Object obj = null;
        try {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // 객체를 파일에 쓰는 메서드
    public void writeObjectFile(Object obj) {
        try {
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 스트림을 닫는 메서드
    public void close() {
        try {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
