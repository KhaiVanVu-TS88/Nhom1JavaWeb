function sendValue(value) {
            // Tạo form ẩn để gửi dữ liệu
            const form = document.createElement('form');
            form.method = 'GET';
            form.action = 'employee_profile'; // Đường dẫn tương đối tới Servlet
            
            // Tạo input ẩn chứa giá trị
            const input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'value'; // Tên tham số Servlet sẽ nhận
            input.value = value;
            
            // Thêm input vào form
            form.appendChild(input);
            
            // Thêm form vào body và submit
            document.body.appendChild(form);
            form.submit();
}



