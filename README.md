# Presente Android

### O que foi desenvolvido
Foram utilizadas três activities, a SplashActivity, a LoginActivity e a HomeActivity. A splash ficou bem simples, o ideal era fazer verificações de login nela. A LoginActivity têm seu grafo de navigation, há alguns fragmentos que não é possível alcançar (outros tipos de cadastro) já que implementamos apenas a parte do estudante. Na HomeActivity, é utilizado a Bottom Navigation, infelizmente a Api desenvolvida fornece apenas o serviço de cadastro e login, sendo a maior parte dos dados feito na HomeActivity fakes. 

### Sobre o código
Para simplificar o desenvolvimento, foi utilizado um Shared ViewModel entre os fragments da mesma Acitivty. Atualmente tenho prática e facilidade com a arquitetura MVP, e durante essa última fase do Camp estava ocupado com o trabalho e a universidade, por isso, minha implementação de MVVM não ficou a ideal. Fica como meta, estudar MVVM e os principais componentes que a Google oferece.
