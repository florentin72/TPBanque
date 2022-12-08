import model.Client;
import model.Compte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BanqueServiceTest {

    private List<Compte> listComptes;
    private BanqueService banqueService;
    @Before
    public void init(){
        banqueService = new BanqueService();
        listComptes = new ArrayList<>();
        Client client = new Client("Ali","Gator");
        Compte compte = new Compte(1550,1,client);
        Compte compte2 = new Compte(1000,2,client);
        Compte compte3 = new Compte(150.50,3,client);
        listComptes.add(compte);
        listComptes.add(compte2);
        listComptes.add(compte3);

    }

    @Test
    public void testSortBySolde(){
        List<Compte> listTrie =   banqueService.sortBySolde(listComptes);
        Assert.assertEquals(3, listTrie.get(0).getNumeroCompte());
        Assert.assertEquals(2, listTrie.get(1).getNumeroCompte());
        Assert.assertEquals(1, listTrie.get(2).getNumeroCompte());
    }

}