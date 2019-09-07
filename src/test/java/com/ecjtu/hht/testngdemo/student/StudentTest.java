package com.ecjtu.hht.testngdemo.student;

import com.ecjtu.hht.testngdemo.api.StudentApi;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * @author hht
 * @date 2019/9/7 11:55
 */
public class StudentTest {
    public static final String GET_STUDENT_URL = "/student/get?id=";
    public static final String LIST_STUDENT_URL = "/student/list";

    //@BeforeSuite整个类 注解的方法将只运行一次，运行所有测试前此套件中。猜想多个类应该也只需要写一个
    //传递参数方式一  通过@Parameters参数 从testng.xml文件中取  @Optional 指定默认值
    @Parameters({"projectName", "runCount", "curTime"})
    @BeforeSuite
    public void init(String projectName, String runCount, @Optional("19700101-111213") String curTime) {
        System.out.println("初始化");
        System.out.println("projectName:" + projectName);
        System.out.println("runCount:" + runCount);
        System.out.println("curTime:" + curTime);
    }

    /**
     * 传递参数方式二：  @DataProvider
     *
     * @return
     */
    @DataProvider(name = "student")
    public Object[][] student() {
        return new Object[][]{{1}};
    }

    @BeforeClass
    public void before() {
        System.out.println("前：");
    }

    @AfterClass
    public void after() {
        System.out.println("后：");
    }


    @Test(dataProvider = "student")
    public void testGetStudentById(Integer id) {
        int status = StudentApi.getStudentStatus(GET_STUDENT_URL + "w");
        Reporter.log("http请求状态码为：" + status);
        Assert.assertEquals(status, 200);
    }

    @Test
    public void testListAllStudent() {
        int status = StudentApi.getStudentStatus(LIST_STUDENT_URL);
        Reporter.log("http请求状态码为：" + status);
        Assert.assertEquals(status, 200);
    }
}
