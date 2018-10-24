package com.sinothk.comm.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sinothk.comm.utils.ToastUtil;

public class UtilsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils_demo);

        ToastUtil.init(this);

//        ArrayList<UserBean> users = new ArrayList<>();
//        users.add(new UserBean("北方", "男", 30));
//        users.add(new UserBean("汕头", "女", 31));
//        users.add(new UserBean("安庆", "男", 23));
//        users.add(new UserBean("南京", "男", 45));
//
//
//        Collections.sort(users, new Comparator<UserBean>() {
//            public int compare(UserBean o1, UserBean o2) {
//                return CollectionUtil.sortChineseFirstSpell(o1.getName()).compareTo(CollectionUtil.sortChineseFirstSpell(o2.getName()));
//            }
//        });
//
//        for (UserBean i : users) {
//            System.out.print(i.getName() + "  ");
//        }
    }
}
