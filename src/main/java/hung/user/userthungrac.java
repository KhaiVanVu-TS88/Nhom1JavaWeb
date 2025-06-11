package hung.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import hung.Object.NguoiDungObject;

public class userthungrac {
	public static String viewUsers(ArrayList<NguoiDungObject> items) {
        StringBuilder tmp = new StringBuilder("");

        // Định dạng ngày giờ phù hợp với chuỗi đầu vào
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        tmp.append("<table id=\"myProjectTable\" class=\"table table-hover align-middle mb-0\" style=\"width:100%\">");
        tmp.append("<thead>");
        tmp.append("<tr>");
        tmp.append("<th>id</th>");
        tmp.append("<th>Tài khoản</th>");
        tmp.append("<th>Mật khẩu</th>");
        tmp.append("<th>Ngày cập nhật</th>");
        tmp.append("<th>Còn lại</th>");
        tmp.append("<th>Hành động</th>");
        tmp.append("</tr>");
        tmp.append("</thead>");
        tmp.append("<tbody>");
        items.forEach(i -> {
            String nguoidung_updated_at = i.getNguoidung_updated_at();
            LocalDateTime updatedDateTime = LocalDateTime.parse(nguoidung_updated_at, formatter);
         
            LocalDateTime now = LocalDateTime.now();

          
            long daysBetween = 60-ChronoUnit.DAYS.between(updatedDateTime, now);
            tmp.append("<tr data-user-id=\"" + i.getNguoidung_id() + "\">");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_id() + "</td>");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_email() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_matkhau() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_updated_at() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + daysBetween + "</td>");
            tmp.append("<td>");
            tmp.append("<div class=\"btn-group\" role=\"group\" aria-label=\"Basic outlined example\">");
            tmp.append("<button type=\"button\" class=\"btn btn-outline-secondary\" onclick=\"confirmAction(" + i.getNguoidung_id() + ", 'restore')\">Hoàn tác</button>");
            tmp.append("<button type=\"button\" class=\"btn btn-outline-secondary\" onclick=\"confirmAction(" + i.getNguoidung_id() + ", 'delete')\">Xóa bỏ</button>");

            tmp.append("</div>");
            tmp.append("</td>");
            tmp.append("</tr>");
        });
        tmp.append("</tbody>");
        tmp.append("</table>");

        tmp.append("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        tmp.append("<script>");
        tmp.append("function confirmAction(id, action) {");
        tmp.append("  let actionText = action === 'restore' ? 'hoàn tác' : 'xóa vĩnh viễn';");
        tmp.append("  Swal.fire({");
        tmp.append("    title: 'Bạn có chắc muốn ' + actionText + ' người dùng này?',");
        tmp.append("    icon: 'warning',");
        tmp.append("    showCancelButton: true,");
        tmp.append("    confirmButtonColor: '#3085d6',");
        tmp.append("    cancelButtonColor: '#d33',");
        tmp.append("    confirmButtonText: 'Đồng ý'");
        tmp.append("  }).then((result) => {");
        tmp.append("    if (result.isConfirmed) {");
        tmp.append("      fetch('', {");
        tmp.append("        method: 'POST',");
        tmp.append("        headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },");
        tmp.append("        body: new URLSearchParams({ id: id, action: action })");
        tmp.append("      })");
        tmp.append("      .then(response => response.json())");
        tmp.append("      .then(data => {");
        tmp.append("        if (data.success) {");
        tmp.append("          Swal.fire('Thành công!', data.message, 'success');");
        tmp.append("          const row = document.querySelector('tr[data-user-id=\"' + id + '\"]');");
        tmp.append("          if (row) row.remove();");
        tmp.append("        } else {");
        tmp.append("          Swal.fire('Lỗi!', data.message, 'error');");
        tmp.append("        }");
        tmp.append("      })");
        tmp.append("      .catch(() => {");
        tmp.append("        Swal.fire('Lỗi!', 'Không thể xử lý yêu cầu.', 'error');");
        tmp.append("      });");
        tmp.append("    }");
        tmp.append("  });");
        tmp.append("}");
        tmp.append("</script>");


        return tmp.toString();
	}
}	
