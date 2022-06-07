package com.example.gmail;

import java.util.ArrayList;
import java.util.List;

public class MailData {
    public static List<MailModel> getMailData(){
        List<MailModel> list = new ArrayList<>();

        MailModel mail1 = new MailModel("An", "Hello Aginomoto", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail2 = new MailModel("Chris", "Liên minh huyền thoại", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail3 = new MailModel("Daniel", "Hello", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail4 = new MailModel("Bui Quang Huy dep trai vo dich", "Hello", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail5 = new MailModel("Maria", "Đợt điều chỉnh mang tới cơ hội đầu tư với định giá hấp dẫn hàng đầu trong 5 năm trở lại đây", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail6 = new MailModel("Huy", "Hello", "Xin chao. Ban an com chua", "12:30 PM");
        MailModel mail7 = new MailModel("Na", "Hello", "Nhận định về diễn biến thị trường chứng khoán giữa tháng 5 vừa qua, VN-Index đã giảm -24% chỉ sau 6 tuần, đưa Việt Nam vào top 3 TTCK giảm mạnh nhất thế giới trong 2022 chỉ sau Hungary và Nga. Trên một nền tảng vĩ mô ổn định, triển vọng tăng trưởng cao của doanh nghiệp, với định giá rất hợp lý, đợt giảm kỷ lục này là hiệu ứng cộng hưởng từ nhiều lý do cả trong và ngoài nước. Nhưng áp lực lớn nhất là dòng tiền ngắn hạn rút khỏi thị trường do ảnh hưởng từ việc chấn chỉnh thị trường trái phiếu doanh nghiệp và hoạt động thao túng TTCK.", "12:30 PM");

        list.add(mail1);
        list.add(mail2);
        list.add(mail3);
        list.add(mail4);
        list.add(mail5);
        list.add(mail6);
        list.add(mail7);

        return list;
    }
}
