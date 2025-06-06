import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifyFileTimes {
    public static void main(String[] args) {
        // 替换为你的文件路径
        Path filePath = Paths.get("D:\\文件路径");

        try {
            // 时间格式化工具类
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // --- 分别设置不同的时间 ---
            // 设置创建时间
            // Date creationDate = sdf.parse("2025-05-25 20:45:11"); // 例如: 设置为 2024-01-01 10:00:00
            // FileTime newCreationTime = FileTime.fromMillis(creationDate.getTime());
            // Files.setAttribute(filePath, "creationTime", newCreationTime);

            // 设置最后修改时间
            Date modifyDate = sdf.parse("2025-04-07 17:02:01"); // 例如: 设置为 2024-06-15 14:30:00
            FileTime newModifyTime = FileTime.fromMillis(modifyDate.getTime());
            Files.setLastModifiedTime(filePath, newModifyTime);

            // 设置最后访问时间
            // Date accessDate = sdf.parse("2025-06-03 10:54:45"); // 例如: 设置为 2024-07-20 09:15:45
            // FileTime newAccessTime = FileTime.fromMillis(accessDate.getTime());
            // Files.setAttribute(filePath, "lastAccessTime", newAccessTime);
            // --- 时间设置结束 ---

            System.out.println("文件时间已修改。");
            //System.out.println("创建时间设置为: " + sdf.format(creationDate));
            System.out.println("最后修改时间设置为: " + sdf.format(modifyDate));
            //System.out.println("最后访问时间设置为: " + sdf.format(accessDate));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("修改文件时间失败。");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
