/*function escapeJavaScript(str) {
    if (str == null) return '';
    return String(str).replace(/'/g, "\\'").replace(/"/g, '\\"').replace(/`/g, '\\`').replace(/\n/g, '\\n').replace(/\r/g, '\\r');
}

const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1)) || '';

function sendValue(value) {
    const form = document.createElement('form');
    form.method = 'POST';
    form.action = 'employee_profile';
    const input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'value';
    input.value = value;
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}

function populateEditForm(id, email, password, fullName, phone, address, balance, englishLevel) {
    document.getElementById('editUserId').value = id;
    document.getElementById('editEmail').value = email;
    document.getElementById('editPassword').value = password;
    document.getElementById('editFullName').value = fullName;
    document.getElementById('editPhone').value = phone;
    document.getElementById('editAddress').value = address;
    document.getElementById('editBalance').value = balance;
    const radio = document.querySelector(`input[name="editTrinhdo"][value="${escapeJavaScript(englishLevel)}"]`);
    if (radio) radio.checked = true;
    document.getElementById('togglePassword').setAttribute('data-visible', 'false');
    document.getElementById('editPassword').type = 'password';
    document.getElementById('togglePassword').innerHTML = '<i class="icofont-eye-blocked"></i>';
}

function updateTableRow(id, email, password, fullName, phone, address, balance, englishLevel, updatedAt) {
    const row = document.querySelector(`tr[data-user-id="${id}"]`);
    if (row) {
        const cells = row.getElementsByTagName('td');
        cells[1].textContent = email || '';
        cells[2].textContent = password || '********';
        cells[3].textContent = fullName || '';
        cells[4].textContent = phone || '';
        cells[5].textContent = address || '';
        cells[6].textContent = balance || '0';
        cells[8].textContent = updatedAt || new Date().toLocaleString('vi-VN');
        const editButton = cells[9].querySelector('.edit-user');
        editButton.setAttribute('onclick', `populateEditForm(${id}, '${escapeJavaScript(email)}', '${escapeJavaScript(password || '')}', '${escapeJavaScript(fullName)}', '${escapeJavaScript(phone || '')}', '${escapeJavaScript(address || '')}', '${escapeJavaScript(balance || '0')}', '${escapeJavaScript(englishLevel || '')}')`);
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const editUserBtn = document.getElementById('editUserBtn');
    const togglePassword = document.getElementById('togglePassword');
    if (togglePassword) {
        togglePassword.addEventListener('click', function() {
            const passwordInput = document.getElementById('editPassword');
            const isVisible = this.getAttribute('data-visible') === 'true';
            if (isVisible) {
                passwordInput.type = 'password';
                this.innerHTML = '<i class="icofont-eye-blocked"></i>';
                this.setAttribute('data-visible', 'false');
            } else {
                passwordInput.type = 'text';
                this.innerHTML = '<i class="icofont-eye"></i>';
                this.setAttribute('data-visible', 'true');
            }
        });
    }

    if (editUserBtn) {
        editUserBtn.addEventListener('click', function() {
            const id = document.getElementById('editUserId').value;
            const email = document.getElementById('editEmail').value.trim();
            const password = document.getElementById('editPassword').value.trim();
            const fullName = document.getElementById('editFullName').value.trim();
            const phone = document.getElementById('editPhone').value.trim();
            const address = document.getElementById('editAddress').value.trim();
            const balance = document.getElementById('editBalance').value.trim();
            const checkedRadio = document.querySelector('input[name="editTrinhdo"]:checked');
            const englishLevel = checkedRadio ? checkedRadio.value : '';

            const editModal = document.getElementById('editholiday');
            const bootstrapModal = bootstrap.Modal.getInstance(editModal);

            if (!email || !fullName || !phone || !address || !balance || !englishLevel) {
                bootstrapModal.hide();
                Swal.fire({
                    title: 'Lỗi!',
                    text: 'Vui lòng điền đầy đủ tất cả các trường bắt buộc',
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
                return;
            }

            fetch(`${contextPath}/tablemember`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: `action=edit&id=${encodeURIComponent(id)}&email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}&fullName=${encodeURIComponent(fullName)}&phone=${encodeURIComponent(phone)}&address=${encodeURIComponent(address)}&balance=${encodeURIComponent(balance)}&englishLevel=${encodeURIComponent(englishLevel)}`
            })
            .then(response => response.json())
            .then(data => {
                bootstrapModal.hide();
                if (data.success) {
                    updateTableRow(id, email, password, fullName, phone, address, balance, englishLevel);
                    Swal.fire({
                        title: 'Thành công!',
                        text: data.message,
                        icon: 'success',
                        confirmButtonText: 'OK'
                    });
                } else {
                    Swal.fire({
                        title: 'Lỗi!',
                        text: data.message,
                        icon: 'error',
                        confirmButtonText: 'OK'
                    });
                }
            })
            .catch(error => {
                bootstrapModal.hide();
                Swal.fire({
                    title: 'Lỗi!',
                    text: 'Có lỗi xảy ra: ' + error,
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
            });
        });
    }
});

function deleteUser(userId) {
    Swal.fire({
        title: 'Bạn có chắc chắn?',
        text: 'Bạn sẽ không thể hoàn tác lại hành động này!',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Xóa',
        cancelButtonText: 'Hủy'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(`${contextPath}/tablemember`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: `action=delete&id=${encodeURIComponent(userId)}`
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    const row = document.querySelector(`tr[data-user-id="${userId}"]`);
                    if (row) row.remove();
                    Swal.fire({
                        title: 'Đã xóa!',
                        text: data.message,
                        icon: 'success',
                        confirmButtonText: 'OK'
                    });
                } else {
                    Swal.fire({
                        title: 'Lỗi!',
                        text: data.message,
                        icon: 'error',
                        confirmButtonText: 'OK'
                    });
                }
            })
            .catch(error => {
                Swal.fire({
                    title: 'Lỗi!',
                    text: 'Có lỗi xảy ra: ' + error,
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
            });
        }
    });
}*/