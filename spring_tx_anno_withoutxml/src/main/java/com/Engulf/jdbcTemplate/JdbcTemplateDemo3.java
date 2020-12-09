package com.Engulf.jdbcTemplate;

import com.Engulf.domain.Champion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD
 */

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(id,name,gold) values(?,?,?)",4,"LuLu",1000);

        //更新
//        jt.update("update account set name=?,gold=? where id=?","QSB",1,8);

        //删除
//        jt.update("delete from account where name = ?","QSB");

        //查询所有
//        List<Champion> champions =  jt.query("select * from account where gold > ?",new AccountRowMapper(),500);
        /*List<Champion> champions =  jt.query("select * from account where gold > ?",new BeanPropertyRowMapper<Champion>(Champion.class),500);
        for(Champion c:champions){
            System.out.println(c);
        }*/

        //查询一个
        /*List<Champion> champion =  jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Champion>(Champion.class),1);
        System.out.println(champion.isEmpty()?"无查询结果":champion.get(0));*/

        //查询返回一行一列(使用聚合函数,但不加group by子句)
        int num = jt.queryForObject("select count(*) from account where gold < ?",Integer.class,1000);
        System.out.println(num);
    }
}

/*

//    List<Champion> champions =  jt.query("select * from account where gold > ?",new AccountRowMapper(),500);
*/
/**
 * 配合 new AccountRowMapper() 使用 但我们可以直接用spring提供的 new BeanPropertyRowMapper<Champion>(Champion.class)
 * 定义Champion的封装策略
 *//*

class AccountRowMapper implements RowMapper<Champion>{
    */
/**
     * 把结果集中的数据封装到Champion中，然后由spring把每个Champion加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     *//*

    @Override
    public Champion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Champion ch = new Champion();
        ch.setId(rs.getInt("id"));
        ch.setName(rs.getString("name"));
        ch.setGold(rs.getFloat("gold"));
        return ch;
    }
}

*/
