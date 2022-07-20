import com.itheima.poij.Brand;
import com.itheima.service.BrandService;
import org.junit.Test;

import java.util.ArrayList;

public class testFunction {
    private BrandService brandService = new BrandService();

    @Test
    public void test1() {
        ArrayList<Brand> brands = brandService.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    public void test2() {
        brandService.addBrand(new Brand(null,"asfs","浪花是咯按规划局",1));
    }

    @Test
    public void test3() {
        Brand brand = brandService.selectByID(2);
        System.out.println(brand);
    }

    @Test
    public void test4() {
        brandService.updateById(new Brand(4,"中华","ag",0));
    }

    @Test
    public void test5() {
        brandService.deleteById(6);
    }
}
