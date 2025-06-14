package hung.user;

import java.util.ArrayList;

import hung.Object.NguoiDungObject;

public class userLibrary {
    public static String viewUsers(ArrayList<NguoiDungObject> items) {
        StringBuilder tmp = new StringBuilder("");

        tmp.append("<table id=\"myProjectTable\" class=\"table table-hover align-middle mb-0\" style=\"width:100%\">");
        tmp.append("<thead>");
        tmp.append("<tr>");
        tmp.append("<th>id</th>");
        tmp.append("<th>Tài khoản</th>");
        tmp.append("<th>Mật khẩu</th>");
        tmp.append("<th>Tên</th>");
        tmp.append("<th>SDT</th>");
        tmp.append("<th>Địa Chỉ</th>");
        tmp.append("<th>Số dư</th>");
        tmp.append("<th>Ngày tạo</th>");
        tmp.append("<th>Ngày cập nhật</th>");
        tmp.append("<th>Hành động</th>");
        tmp.append("</tr>");
        tmp.append("</thead>");
        tmp.append("<tbody>");
        items.forEach(i -> {
            tmp.append("<tr data-user-id=\"" + i.getNguoidung_id() + "\">");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_id() + "</td>");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_email() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_matkhau() + "</td>");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_hoten() + "</td>");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_sdt() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_diachi() + "</td>");
            tmp.append("<td class=\"text-danger\">" + i.getNguoidung_sodu() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_created_at() + "</td>");
            tmp.append("<td class=\"text-danger text-truncate\">" + i.getNguoidung_updated_at() + "</td>");
            tmp.append("<td>");
            tmp.append("<div class=\"btn-group\" role=\"group\" aria-label=\"Basic outlined example\">");
            tmp.append("<button type=\"button\" class=\"btn btn-outline-secondary edit-user\" data-bs-toggle=\"modal\" data-bs-target=\"#editholiday\" onclick=\"populateEditForm(" + i.getNguoidung_id() + ", '" + i.getNguoidung_email() + "', '" + i.getNguoidung_matkhau() + "', '" + i.getNguoidung_hoten() + "', '" + i.getNguoidung_sdt() + "', '" + i.getNguoidung_diachi() + "', '" + i.getNguoidung_sodu() + "', '" + i.getNguoidung_trinhdo() + "')\"><i class=\"icofont-edit text-success\"></i></button>");
            tmp.append("<button type=\"button\" class=\"btn btn-outline-secondary \" onclick=\"deleteUser(" + i.getNguoidung_id() + ")\"><i class=\"icofont-ui-delete text-danger\"></i></button>");
            tmp.append("<button type=\"button\" class=\"btn btn-outline-secondary view-detail\" onclick=\"sendValue(" + i.getNguoidung_id() + ")\"><i class=\"icofont-eye text-danger\"></i></button>");
            tmp.append("</div>");
            tmp.append("</td>");
            tmp.append("</tr>");
        });
        tmp.append("</tbody>");
        tmp.append("</table>");

        tmp.append("<script>");
        tmp.append("function sendValue(value) {");
        tmp.append("const form = document.createElement('form');");
        tmp.append("form.method = 'POST';");
        tmp.append("form.action = 'employee_profile';");
        tmp.append("const input = document.createElement('input');");
        tmp.append("input.type = 'hidden';");
        tmp.append("input.name = 'value';");
        tmp.append("input.value = value;");
        tmp.append("form.appendChild(input);");
        tmp.append("document.body.appendChild(form);");
        tmp.append("form.submit();");
        tmp.append("}");

        tmp.append("function populateEditForm(id, email, password, fullName, phone, address, balance, englishLevel) {");
        tmp.append("document.getElementById('editUserId').value = id;");
        tmp.append("document.getElementById('editEmail').value = email;");
        tmp.append("document.getElementById('editPassword').value = password;");
        tmp.append("document.getElementById('editFullName').value = fullName;");
        tmp.append("document.getElementById('editPhone').value = phone;");
        tmp.append("document.getElementById('editAddress').value = address;");
        tmp.append("document.getElementById('editBalance').value = balance;");
        tmp.append("const radio = document.querySelector(`input[name=\"editTrinhdo\"][value=\"${englishLevel}\"]`);");
        tmp.append("if (radio) radio.checked = true;");
        tmp.append("document.getElementById('togglePassword').setAttribute('data-visible', 'false');");
        tmp.append("document.getElementById('editPassword').type = 'password';");
        tmp.append("document.getElementById('togglePassword').innerHTML = '<i class=\"icofont-eye-blocked\"></i>';");
        tmp.append("}");

        tmp.append("function updateTableRow(id, email, password, fullName, phone, address, balance, englishLevel, updatedAt) {");
        tmp.append("const row = document.querySelector(`tr[data-user-id=\"${id}\"]`);");
        tmp.append("if (row) {");
        tmp.append("const cells = row.getElementsByTagName('td');");
        tmp.append("cells[1].textContent = email;");
        tmp.append("cells[2].textContent = password || '********';");
        tmp.append("cells[3].textContent = fullName;");
        tmp.append("cells[4].textContent = phone || '';");
        tmp.append("cells[5].textContent = address || '';");
        tmp.append("cells[6].textContent = balance || '0';");
        tmp.append("cells[8].textContent = updatedAt || new Date().toLocaleString('vi-VN');");
        tmp.append("const editButton = cells[9].querySelector('.edit-user');");
        tmp.append("editButton.setAttribute('onclick', `populateEditForm(${id}, '${email}', '${password || ''}', '${fullName}', '${phone || ''}', '${address || ''}', '${balance || '0'}', '${englishLevel || ''}')`);");
        tmp.append("}");
        tmp.append("}");

        tmp.append("document.addEventListener('DOMContentLoaded', function() {");
        tmp.append("const editUserBtn = document.getElementById('editUserBtn');");
        tmp.append("const togglePassword = document.getElementById('togglePassword');");
        tmp.append("if (togglePassword) {");
        tmp.append("togglePassword.addEventListener('click', function() {");
        tmp.append("const passwordInput = document.getElementById('editPassword');");
        tmp.append("const isVisible = this.getAttribute('data-visible') === 'true';");
        tmp.append("if (isVisible) {");
        tmp.append("passwordInput.type = 'password';");
        tmp.append("this.innerHTML = '<i class=\"icofont-eye-blocked\"></i>';");
        tmp.append("this.setAttribute('data-visible', 'false');");
        tmp.append("} else {");
        tmp.append("passwordInput.type = 'text';");
        tmp.append("this.innerHTML = '<i class=\"icofont-eye\"></i>';");
        tmp.append("this.setAttribute('data-visible', 'true');");
        tmp.append("}");
        tmp.append("});");
        tmp.append("}");

        tmp.append("if (editUserBtn) {");
        tmp.append("editUserBtn.addEventListener('click', function() {");
        tmp.append("const id = document.getElementById('editUserId').value;");
        tmp.append("const email = document.getElementById('editEmail').value.trim();");
        tmp.append("const password = document.getElementById('editPassword').value.trim();");
        tmp.append("const fullName = document.getElementById('editFullName').value.trim();");
        tmp.append("const phone = document.getElementById('editPhone').value.trim();");
        tmp.append("const address = document.getElementById('editAddress').value.trim();");
        tmp.append("const balance = document.getElementById('editBalance').value.trim();");
        tmp.append("const englishLevel = document.querySelector('input[name=\"editTrinhdo\"]:checked')?.value || '';");

        tmp.append("const editModal = document.getElementById('editholiday');");
        tmp.append("const bootstrapModal = bootstrap.Modal.getInstance(editModal);");

        tmp.append("if (!email || !fullName || !phone || !address || !balance || !englishLevel) {");
        tmp.append("bootstrapModal.hide();");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Lỗi!',");
        tmp.append("text: 'Vui lòng điền đầy đủ tất cả các trường bắt buộc',");
        tmp.append("icon: 'error',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("return;");
        tmp.append("}");

        tmp.append("fetch('tablemember', {");
        tmp.append("method: 'POST',");
        tmp.append("headers: {");
        tmp.append("'Content-Type': 'application/x-www-form-urlencoded',");
        tmp.append("},");
        tmp.append("body: `action=edit&id=${encodeURIComponent(id)}&email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}&fullName=${encodeURIComponent(fullName)}&phone=${encodeURIComponent(phone)}&address=${encodeURIComponent(address)}&balance=${encodeURIComponent(balance)}&englishLevel=${encodeURIComponent(englishLevel)}`");
        tmp.append("})");
        tmp.append(".then(response => response.json())");
        tmp.append(".then(data => {");
        tmp.append("bootstrapModal.hide();");
        tmp.append("if (data.success) {");
        tmp.append("updateTableRow(id, email, password, fullName, phone, address, balance, englishLevel);");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Thành công!',");
        tmp.append("text: data.message,");
        tmp.append("icon: 'success',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("} else {");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Lỗi!',");
        tmp.append("text: data.message,");
        tmp.append("icon: 'error',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("}");
        tmp.append("})");
        tmp.append(".catch(error => {");
        tmp.append("bootstrapModal.hide();");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Lỗi!',");
        tmp.append("text: 'Có lỗi xảy ra: ' + error,");
        tmp.append("icon: 'error',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("});");
        tmp.append("});");
        tmp.append("}");
        tmp.append("});");

        tmp.append("function deleteUser(userId) {");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Bạn có chắc chắn?',");
        tmp.append("text: 'Bạn sẽ không thể hoàn tác lại hành động này!',");
        tmp.append("icon: 'warning',");
        tmp.append("showCancelButton: true,");
        tmp.append("confirmButtonColor: '#3085d6',");
        tmp.append("cancelButtonColor: '#d33',");
        tmp.append("confirmButtonText: 'Xóa',");
        tmp.append("cancelButtonText: 'Hủy'");
        tmp.append("}).then((result) => {");
        tmp.append("if (result.isConfirmed) {");
        tmp.append("fetch('tablemember', {");
        tmp.append("method: 'POST',");
        tmp.append("headers: {");
        tmp.append("'Content-Type': 'application/x-www-form-urlencoded',");
        tmp.append("},");
        tmp.append("body: 'action=delete&id=' + userId");
        tmp.append("})");
        tmp.append(".then(response => response.json())");
        tmp.append(".then(data => {");
        tmp.append("if (data.success) {");
        tmp.append("const row = document.querySelector(`tr[data-user-id=\"${userId}\"]`);");
        tmp.append("if (row) row.remove();");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Đã xóa!',");
        tmp.append("text: data.message,");
        tmp.append("icon: 'success',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("} else {");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Lỗi!',");
        tmp.append("text: data.message,");
        tmp.append("icon: 'error',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("}");
        tmp.append("})");
        tmp.append(".catch(error => {");
        tmp.append("Swal.fire({");
        tmp.append("title: 'Lỗi!',");
        tmp.append("text: 'Có lỗi xảy ra: ' + error,");
        tmp.append("icon: 'error',");
        tmp.append("confirmButtonText: 'OK'");
        tmp.append("});");
        tmp.append("});");
        tmp.append("}");
        tmp.append("});");
        tmp.append("}");
        tmp.append("</script>");

        return tmp.toString();
    }
}