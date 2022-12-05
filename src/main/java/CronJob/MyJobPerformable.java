package CronJob;

import Model.Product;
import Service.implementations.ProductDaoImpl;
import lombok.extern.java.Log;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

public class MyJobPerformable extends AbstractJobPerformable<Product>{
    private static final Logger LOG = Logger.getLogger(MyJobPerformable.class.getName());

    @Resource
    private ProductDaoImpl myProductService;

    @Override
    public PerformResult perform(MyCronJobModel myCronJobModel) {

        List<Product> lstProducts=myProductService.getByProductCode();
        for(Product product : lstProducts)
        {
            LOG.info("product"+product);
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
