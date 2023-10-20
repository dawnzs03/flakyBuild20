/*
 * Copyright (C) 2023 Hedera Hashgraph, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.swirlds.common.test.fixtures.crypto;

import com.swirlds.common.crypto.KeyType;
import com.swirlds.common.crypto.KeyUtils;
import com.swirlds.common.crypto.SerializablePublicKey;
import com.swirlds.common.utility.CommonUtils;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class PreGeneratedPublicKeys {
    public static List<String> rsaPublicKeys = List.of(
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100a94cc888ccd96a960d4d802c0477089223fc06671e66747647c35e36f904b6d93d710c1c4b437d4c13af04658f67548e54fc4b9418968dda1228ef9550cc69ce56300139708807e3f44fd5bdcf8b473a0aa3b2195b6ee989b91f51c0b1270e85abf43e705c14a9a7a9c98e6b3baf0a886b59a24c3ad7ea010f479274f70966f2bf4595c2eab3a155e97f5ce92a83be340918f7d5a399db700e1053bb1d1dcd74b35991e173d0705c0a87341d18bd7d6f38ba464266f8f23efc3558411eb8b37585472d3fec8b73af20c2679d4a4ad2993cb4334c47463a4790ca77ea8538d628131d451d14eae4e0e04f88e87d18db431d52b31c60b09596f226ca25d0741f41a136ecc51383506c1d83e930190707703aeb30e37279220608de587ac1dd90e301014f5e0012e5784f5ce961bb1b935e8ef94a371133ca71d99e18456aa09227438361f73d4f56f918b6b06cdfa502b232dde39f27d69d702bfdb916ef2432ae16d9d610e65535e4783e260e824201d323f60034cd74747ee540cb0eeec3ef3d0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181008e6f9b94fcc9789a183c80cd6ba15b6f55e3a8bf27bc96e714cdc71483a03f8c24f27d5ca1d5761bf67f70c7061fa0171c1538d4a5cd6b12cf3021c77d26395dada848161a1845de8d5bf9142b2b614189ac46bbd3f6ef7a19640a1be4cbb6307f679a90a7681689952c340fbb03d7461db9571836bee9c4de3df7474e8be9a3c66119ad871df5b78f09dc5fb1670fb0a271d472a254d963650c382edd78bf5fa4635ae6d09fa8c644afe9ec2303a0e501090aaf08775a9995af9c828dcb4b58d8f05a434c59cd9953d7dff537bf1b31359a9efa0d608934f2ed74ddcd27bb1a0b233ff840cdec4bb6284942023b9d078b398f1a285eedefefd24fb3698ef3bec85d8145997fcd6d21e3d9a2a68aa0769117d386a19e0e5767590066cfcdf95b61f2602d40dbd52a4c7bfd62985e193e8f79be30e030ef0935911725332a1f2ad7465383142fb30ade79a98b9c580adee94e1de087b55bf021b8fb198d3fe3ef2dd4f9e8ef7ac1d043219e1a2246c4156942f78ed6a91c91f7225f416e76f67d0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100949d8b50fc1fd1731fa5a6f1192cb3a8fdeea4eb699d614e852637459b0cda2278987109646e642be112ea2c411c547e7303f691944aad3c6b301308a18e6e12b1fc7986f1ee681a655c92597eb5324d4c5947c41ace985b5f0b044d2a87d45c5ab32023116e38d4f032176e880f152c56e48c9dff9ed754afcef1d69af64957582ab8a9b3d6c708c1b25cbee22d85afd9b9b658a8d33fb98f3100b9df3755fa82699ec9d5397865130cef4823110a6b1448f4f663e053c40af1ab20548258218b79be7d9a50c733ff328fa7276f0b2cf05ad672b155e7c3a73a3ef32ef1e6649876221ac4e9a1a5d9771e813ae5e6801301fba3a6454ebe3db91b723adc17711bf700ad20beb4d9d110f17ba814f8d1a36437be4c74d0b2e4fcdb2734a5ab449746a8e840d98cfba4519d5c30413a18fb549c260c5f3bfda5c3c632eb0c532c038a93a0b510729b8f7714679a91598d3f0beb91231a30100a95f4bc70d80f4868c879eca3453425fe0db1fd5cbd4745e8e56bfc360e4ac40b28321c65aa80a70203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100b44efeddc2858685c81c7eb1d48d16649735ce48f9d9de16809eee113e7323d7876ed1ecf9baee1805109eccb18189ef882d7e0b23642b2fb43aed67b680ae66fcfe4de7451a8702c92f0e4e72ccd16e99a7df638364e795f342e09cbffcd375e4b150efb07fd385a1efa35d00543f63df2e63f20371d98fceb50b72748920a2db141731ec9a96782ba49ab4e7d6d34f43ce3f8728094e0ffe7d0b9f51eab37cfd418bcd3bded1b215ec6a9614012206a367f278368bbef8fb5c7e812c9c58b074cba4ff6d39a6498cdd105f2a902730e77f8e8d1168a7bab5384a17d7eb44caac368b62ba4d931f995094286334e715c8c78e9396c749a182ff9e08acae07ab05f20e4d0d9242d984ad7014ab5d4a7bd50a171875beb4e344d3e8d74785110b4e238b1f1903d1116d4dba8179809f007448b4e24da53f4dc51f64070e1cf9013d027a92261ef8b02a6e85869060fa0c3b28b5c16440d804773e5533ae14ba2be17936d6de095a11b2c630069ff944f27ed59918f5acff111ad4058529e7e8090203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a028201810096db1b25533358c75d249ea2298fc8fd975a89aa0f6de5c06a543d67a40341e6b5b9b6f60e029baf31a0eb45c7c2be90dc718dd29841fac933840f45ecad5bbb92c06411ff9ccbaa3d8ab3d05c31c37d587b68903f07a0596f64aaa8fa76ed5a95f579c058ead888e0f8ed7e6047cadc303341d591698f7dfab7d2bd436672c6cd1c15099e08eb14e12f4ee8348b7f94cbb4294687a772028bfdb79695af1e4ddba860f635cc36ce9234a887c2ff7fb6f3435ad93ffe116a002b92c2325b7cb810075d6fbdd125275bed4e265a10f337131f14c9631f311970d00ed0f9f972d040a7421063d23c7a8f274523c18f44a872d63fd92a404642d170f35f8830830e0ea91aa6916a8f43ed4f7b349741d0c4577d11ede9869821a9c652b9a2ca4a894971ce8322eaaaeb93022e4e8f63a560e571003e2e6a40f8067280f4158bb3364c0f5f0c397d9ca3f64376f0813ea794057be181a2ffcb8e2e9d1d7124c43c504f91bb87c4f63f6adec67b5ddb8c98a615849e2fa22721b52f53ad45664f41210203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009716d441c76fd47fdf2f7219f0ac8d1c5adfe848960ab48b80e6d92edf86f631438a7d1df5180a8c870acc82214cf55b272441e3e45a90322b42634ace3bfca2ee6591f0996dd8181bd23000eae39e76c48d3907cb8fca8ee912a296522973db112d0a22bb6dac637848eb9de11f6084ba2ddb5dcfbcb704b72faac57c065f34c83eaa6103ae40a5398ba92d29553703a243752023d55a480c86ee3788a68384dedff82e2dc03f24485dfd9bce62da25aa5f6176c525f606f3f5d21cb0bf49c1defe8d1c1928fa78e05690caf19567e42f5fc6b5d69f58a438fc821159849c79d839a6ee7fd247e86d218f42a18d7f3d11d1cc7a8ac3761cf4a326652947d390d6226f1bb7a99575b6ff2e8110fc777fcf24e9cfe2649c51cc56ed8925e2db9634153a3309ba9e76f67a930a7bcf7b21fadc1396babe84ff3ff0bbc4210bf9c7b9d51147ef3ce1871233e80ae99eac460042c4d9243e21f9334931b8957a02382a25b76f43c8329a9d146c17a07a92a1b86a14bd3417337b3a3d8cace912d4990203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100969181f16164b16c57e691a959f0b8137f17f2b5d962e3b16d79d230fef0053dd837aa9404d90aea98520d3cad6498a76e34ce7eebf49ae4c317ad452b5051fd3ba1d3c9020f5167f719cd091ccbbe3eb312013c8c5c25b80580054f69523dcc33424237f9d51d93df619f66f2b77514ef9e07c7e2d74748a3f07179ef9c58aea252bee958dcc8bcb3193ea7f66d67c3378e3e86cf92419feef5757a500618a04702400c7151917b674dc72f22ee9c642a7e3a367bf9a6d574a10c4ba405954a6e5464fdc67663da435c1e00241d8b0ea79d9f67545d30a74be629ab958b7f4c2b195262252de27ce703b3efe78c42533b826cfabe4d44566eac8271daf05e86c90eb4b90991005450b05ada8da8fcea10e8e964a63dfffc43f64c3669a86863f1c00e80fc776b5c79f96792e541ec987d78bc61ed9ce024d341ad6d457ff78f9b68be7ff33e546ce0b2d73f383e1762c8f079d5faf107265b8ad328f4f4aa75e00a1308a8d4c675871dd7eaeeb3b9f71190dda9f1cf1d9382003896628eeb1d0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100c0cc2cb279fd8129fd7dbfe14ae4840d1da435f0173ed4bf28f2828205dfe3d9383e409b6e153fb8be1b7c55591cb111e229fe1e39eb728039df3e950fed80006df960f9920ac037a5b9e53c85bbe2181d38a71fb77a22949ec75a3f6144dbc9c47fd1832a20306fe0fcb06e703725467fffd066384418f6d4a439a4a707e20963dded8d1d00d4a89901cd15d913509b2b0fedf501392d7ee1eadec1c124f96fd6a3c4ea67fb8da4b676897717bada5ba2c31c78ee5097e15c05d12d8bf0f3310c0a8d9d987eaa1b47e1d6922b748a0aec7bec3847107c392d93c4134dd283a82b261c66a7813d26dda9caef0c0252d3c25ce3b2fa95f363bf35fc4875eb2454825ca4f8d8acd9c250991cb5613311d519c3bdbcbba9a06c3a1bcc435a760f35fe9b0cee516ece46f35fe49091c6a949e8dc10e7540661db86a247fb73599bc8f130c86150d235ea7e9739cc9b8e50863ab306d68ce245a8990379690f151ce49776bece1d7bff8f4bc4fb1dd3292500f279bf827ec9ed4bdeeeecc6b98ae2cb0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009728c8dd542303eff574ccbc029ff24e19a25c562ddd5a81bce310cafcd9f66f80942bcabb66db64497d20b63d377a03ab49f96488e9e8a2811a55ab13d626f28ff06766051f1865c8a2c2a2ccae54a813f0dc647f49f4e9723e643001eb5ea05b7d80d2d04be4eb168436a4c2d1e6d2419d04004de9a6ebb4c25b789ea6271013874db29344e92c4dbea6a39edb06ad56d9f8f06534df0d9b3fc89e2705f7eac5314d7164f99378d1f0c780b9e2b9291492557c1d2d51acea7bd2526095c6ebbc26e15099ea38e08fe841a1b292627c8e391c9ffcd87ba101a044746829ba135eb2ce7c6ca2e9c07c91c2ba0c7fe9ecd1d04547442187b679be2d1e3375590bd247b703f4bf028bc72a9ace106b0023f953c6191875158a7174edbd733a55f97d5b4329f7651318b19c22e7e8cc73355d679b2c22ac427aebf63e3449414fa1de7938845009bf10a4984ddd7742cd24314993cbfbfb80d987c036ca0ea2ecf2d56e30a345ae2749864404fc315a18014af3c9be5b253066ee0b8293e20baec70203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100880eeee41c2e2ba7f71f943e4b41b74207ef324934981eb7befb110d444dab5b4796d8c7ffaeec45ec6b0f68ec649328e2bb2c268160cf0af31fcdd26235ce7f42d148fb3c662544cae83a0616b6886f752ab3fbbe3019949496944d0df4b5d6613274f5354d441db4eb877bcbf0f609406453c96e7431405c7786541077e150b3deb630d62a8c932b4ba6c9f1ca1ab1c79a52c89d162b9f8702b9c5257c16cf4679c70d8909a166402873ef64933893b4d5e6a28c07d071d8ef35f0a28658fe399503fdbc9b6fd1335d8bfc2f302a23cd6177b47a9762c8f2a00a4e272929674b0ec72d186500cdc866f4e20e3779a63eebb04c1a0c74072bcf85480c68660ef17477c7ac07a82f0d5485a64bd047e9f554d1c9fde16696b7d7b0a032b4a2247121fce0836abc7cbd3bb3998cf59858331e4e0094cbe223feae8515231a36047df545d240fa7934c8ea8c223af3f8c414eb09433b451b8434406f26847c525cf8074b5bb8bb4315bbd798308e067eff8eb46d43b60b7e919e1579ea466feedd0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100e29f6eefb9e293bc0b6e9ca31e6596b9fda34954123c44489e761bdce663ad49a958b244d41ef957ba20c981f2fbb5d4b1157bcd2804e1af3476969e25530f8365d1d2c39a761f325187b6fbd47129371bd594dc6bc9f8cad79e6884c86f75c30433d77cc26a571840f746e50887fe4053d706d6273afaa124ce97d6994cb643e306edbcb7482e41545ee0053dec90922ca904508128540f528fde5d5ce5e88da3259ce6b2b193bc7a8747ba09faa18f78b78aa9df1d7677a9cca837df2e37d3ac7fb6a93c55b2670a9a46333c1e0c9bce69e316c1a0a91fa62dd67320fd0f4f72cd78a2e29640ca018194fd96a220a0c498806b617ea0e1544594bddf2297a4cf249d5427015d05de97d07d59d48f686871f0761cde4d7ac258f7cb2b1a380533b20a8278728f07e8b0eed3dc4c6a0194b359bfe17de32b110b94b79dd1247e948f3594a9f8381b91e81b4d4f934c1ab3eea2277b99f342854966fdab64997ca95dce6392452ccb89064678cb8e06d1e6b60e6ace4450bdcddf45cd21a225070203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100b8eaea880a90788b601d6d82a605ec3eafec66a2f67616ebb079b3b047019000b7f064c5bff7d238b46d405ada16dd46c569e5ff05ead83f2afd73d19d29001848c323b8df82c5684de8b51cff9914087b66ad3ac0c00d2fc44d2fbad87348131c4f42475ba5d1b9bf775103719aef264c1079a4d9b509c7cede325285f9e00bcc4cc1a0cef35dae05e657c608a0a32bfccfcd4996b0f32eda141ac95117fa3db618f1e6dfe1ceadd309216d83b8702fc0f26dec14d5db3fc8659984e4b3e6f07c8e3d40ba6904af3b38ec303255e5d9866d1130a3ef66318f6ef365a6941b9e676bfa848427a8fc45da7097d8277ce9ab5ea05b9b007be7471ac946422060c3c7950ced352005d4f95653affab903400afe74b6f0e30fdcf61f6b161f4a44b3b4050c8684cf44ac54876d35300fb04089f0aef0f327ba42147c7bec03d00e772f6621dbff1fe0c8c8895edd516c3a99c445bde60bcba13865e732e9ee1d0769a6ec1d7ad4bf73e02e3163221c15a8fc6284cef3314b45cf7b826d593eb7180f0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009609a6d03c3fc8a1aa39763597f61f5938c769ff3367f2a8dd48c8b63abcc252430f94197fbdd233af59da5027fa47d4ef5e6c6a55f40f5b70876b58fcaaa8e4e7eb96cb52c8106f4d82edd6b7a7025149f99cb88fced7622c85047323168c35517e67c4d5fe087f2ef1980fbf864e8f9c9c3f8f428224d183f3ff976c098742490d96dcdd68036d5d487c9bb1a6e3cd88282112c88f17088b61a0f26e47d3f166211f98da283a57e54f63104c4c8d6ecafdd02cf1747fcce4645cf71f0023fd77b59a4fb2b4ae55319c6905c8bc42c08a1e315518dbccd177dd049cac2645c1a3e056bf43ba62284f718a44caed2546ab5f7f422c8cf9b29abe335ea27d55ee816e90bee8ae1e5f14a2214136bf73e13798d452d183979ff6314940680e74eca08d8eccd47c0312be9ed89b75b08eadf72d663ae9c347462545ddc124d4c12a00d4851ee57242ce688c4515cf3ae0a2794dc5656ece75008f029437d2dbbaf5cf67a13386b83e07e4d3c459c209b91d9b7dbafe340f58c6542f9d5e390a70850203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009d64a67e4a28b11816da4e588b9e35bf93b8b55740c0cbce5adbab0b6ae0db0d5b291ee3e2c11031fc9f402adaf4c4e361085a4757cf12379d3ce764e099205c486cd2682a83d3cf05b05d9e226d2af0de6aa77bb188e80b96f4b68101cdca36b757c31aaaa2678421ebe128a1f65b436c96cca2e5b46e12372b25f69813d49ad7ae363a88277953a363e8ea690d632be458cd5766d50fe36098e91f45c915e64b6d0f4a137a80b2ee76733efcdae9058b01e93ef9b54936bebc659a1792c7b0e88b2b08a49ed8f259106ca717f8b6d37d53966e38c426dfbcf6ab3fa72933aeb3afa74e8327433e7b78ff080f7485db326c53e245ccc445bc39a861b6b49b68da57427cf7fe61f1e2826b1961c7942501c06a3116252d6ca5347e91c288bd4ef8385fd1f239afc1a76638a717b80329989af060b816e8fbd335632fe1e519b27918726f9a5af6d10c0ce5f273b1603bc244ef01ab6391950e2fe22f25cb7a9bf671eb2ea1a8557ba55d7b29b8bf61219d5cab584df5e019004dcb2be64741950203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100e33ff6b40e071949205ffaa476a95aef541c7b1780e4539499f134e51c1e81f3b9bf7190faf92ce8c23b3ec71ad05a7bfe3c17db7b203dd1b75b5e1a441520ceb9722bb803995d35b0b0a4e38f8d3f4cd9b696fca1c8cb917f5707eb3b423bb01ebcba587448f4d1d056e1b73f198f4fe0323bac88696371fc869e431dacec340b79ea8052f10ca425eec4294918634c1e9ba14143c0151d8a43dfb52e8a683fa2cbaecba71259c25076b28ddf7e55b44cc3990e5759ca49a2980061bf956fc5a43fd0e0ed043d79d7a0b966ba31c775a1b3e7e5d762950df3226a8c247ac5db66d98bfc93b4246e35a333b84714c8f752dfc353f1730dda9ddb79b2c9ecd783c15f11ef22eebe78c195d518f0f8cffa96714f7d5da1bba6024c8653dae14d1fba34e7cee3927eadf07a0ff4f64fb69f895de13a15a8ba25a0743f78db117fd939e1b5cc21554bed282997fee9fbb42b9b2bcbf49e6fc32e5fe1ae38e5753bee6f50a6c98b4a9bb7e3a42b1658581ba8d018a245c8a3153ecb30fb0d99e843bb0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a0282018100cef972d45cb92892f71e4084942f5bbb775b673ea3df53aa737e2b529c91409ba0e915a9a274cd8a3d8841278db4d8fcbda97a77c90f874daa84fd23d56031b6f68495abab52b47a6690438e165bba5b9520224b0c6f99e1ca85e077fdaa87134d891c155298529634b40324be4c6d2e889595857e7346005fa1de0a6612be0ee73eb9742a82f6f171ebf8c2d6fcc4815357a0da953457b8ce4827aea9a31abbeb8fa2f43c393508b74779ab7c400469162ee69eb00ca1fae2ef5e8e31338db491cdffc9c5e761d2176b27701b3c23e42e48474a0f5ed8ba3f0f7e022ab0161a277f7b008dd41c87e68a72a4bd59049e48cf999da1e41d06d751f548bba9b8f7cc26973b1451adc82591fe3bad1b8ef5a7baaab366c11589a9653bc0ed0485a1f61fa5f86897f1465da6617e9c7acb21814b61fa0b0a187b7412f1a33ce86f533302a9d1e8f9e42d9141fcef8ecd4ee9805425539622a8621fcd89ecd2fd46bd8acea99c121df4fbdb7c8109d3fe8b671db0d7cdbf8bc6a7224ed696b01b38470203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009243bd3ea042c355856c7e293148645ce635f80a638fc994d9dec47dc0921104b17adaf9e8f9716b389bd1e55d0ba65d4ccabb7f543360ab38cbe330431e3ca63cb11b87923b0bd41202764f56389b9b1ff7b1e84159353103027ad6acac012af3e42f9a5bc740522d709aaba21b7ddc15f1c86e6b7504c1a256e503a441830e9c987688380fb801f00aeccc6b834710385f15fb608ff83ed48ba365ff5c936a7fef47e9b8c87870dbc6030780fd747c16c3d9ea73cddb8bb0d9c77aa89c0166a46c0f7c34b7d0a6fa442826728fdfdffffd9a43bfb38de854f806511738be60aaa62acbc58a97a98c6d42d12a31b246df9460f7ed24e73e3a3a38e4e6330c477a0ae9987b829bdd4abf572b1f396cde11ab42ad4faaae2ec3822d82e3e790e339f98ec4e616e2933c868bdf93bbf09142f10e92b055063ef1fd1c3b8cbb1808c9dc52946f367203e0b56b6a01e38c55f064b0a18a8c78c1508ca732f77bc66b859fb8db4647a879780b6896696acfb6a006474c81bd36fb172cbdac95bc649f0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a02820181009b58cb618a0ba674a6c719ba668b56989271fa777e099c1a583cb3f2511cb08425504633711b787dff730b88664a7f3cc0463c7057a51207730cd62fd4d99b73b15149dc75548e5436c25dc6616396d106cd246360ed922013372d5e46d92893f16767a698c7fd1243219b23a635afd83028364cab2d580a436ebeb4da52fb32bdea50e6d118fbfab086da48cf358b25bc3281a94403e9630b945a748601f954a0da7edcef0ddd8ffb6f6b2be770dbb441824b6905ea9904dbc7f2b550e872dd3ac2760557f3ef19e565bccfc3da4e5dbd07345b735c2994ee8bd72167dec0b4715e86a74717ebddba8e71c13b84af5ded10441917334cfcf996410bd471bb7db8f14416e695d69676f83ad3680ea67ad4d9af5232669f0d1a395d600205d107dac342e496668c8189fafb151d28f346bafa465c5f0748452c75f1cfd12ce47e392681036cf7f3c6a0ff67250bb72717a0f327aa0be35ecf072c92fe2cc0de892737645aa3f5160756deb8e69faa85ea46af455e8ecaf90d6f6df465843b231f0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a028201810080f45cca0798ffb14e38fe9effa098c98a51c98bb5bcd0c2ce6b3ab283e887acc9e77c607b4c7b764d5750f2f520807027ccc2587628c0f5d845e0efb194996524a7097a9992f73ca62b8c26cd746af6a442a277180ef003d5ae02d3221615be2a17a008ac97bd2fe8ae2522e2e0f314e80ad4b8232e57e9dfc349eb0cda101b179f89623d3460c23139108be0a1bc68cf9915ba5353d2a1b68a228e3214b5f31faf3b8491ab985309ed44b2ebf4ed6cb4fd4485f84c677be2682991fb01cf12d4cf353cb86150ba43f2c29934a672ed8fa08736ad08b17e09c8e92bdecc008b4813c5b787dc01ffece3a59a0fc5873e42421aec67a32032ee128d81f121749453e5073cc7f0f029d66396328436b2c74075e88845e707db405df76e6f327f6aa51c470be497c6c549f1ddd6a92804cb0fb10e8bf5a3c9a243fe0d506e54e94ffff21b2444215f7fdb73b2732b1bb35d22a5a38856e2165c076380b5a192afd39c3d50ff1447548c79c64c6d7c4ec6fc912d908bd76f73ff137139f0f6b0709d0203010001",
            "308201a2300d06092a864886f70d01010105000382018f003082018a028201810098d777c66a3fa195b2e466cf95fcca917796492b447277740bd1e26c56d9a9a63a40c1b43b42660f193484533891d253c1fb31a3cae461ababcbf5247a66214b82de0d3e12fc5d0dd895007584f150b5b8281baaadf3b58715b2f7a08cd2af8b2c107e40a3ceb721592222e073638d52c34fbb9c44b8a81c0fafab2cfa85d8e1612060ca9232735988c414c6d1df9cab4cd82726c3bd4e3d54649c9f019fbd32bb9403324e27b665f281fb7acae9eecf85b89183fdaa5835d8300405a6b7cd9049ac132505c2ec24617bdad23d7cf488ba7d3fd73b380f5002ec73202d86da0d0de5d8dd5f49f29a860740c1112844d71db1d301f55c93928fd61f60b415ce2059af160a085b721ab4a6c97924d0d81f84dfee9397d8eeb040079b16db8783634da9aa52480f538aa4cb5385bd732151d47cb52e06020d8655152eb35f5ec258d8c18967f191c0b573b5ca96eb33b3a400df424160baa9fda1762eaefc214cb0ddbb1e1e7e94497c1625dd15f912566a305c17336cf8a437cda2be374287c9b70203010001");
    public static List<String> ecPublicKeys = List.of(
            "3076301006072a8648ce3d020106052b81040022036200048bbe41ed2e267cd88df75199a89cf40f43616158aaebb4e057789c35f89332dfe075a9f4cf553c4bfa8db2dc34557409ddc3b0f362a4d691b47d9fccafd88dc870790c87e2eb13c4e2fdf8cab3c28241060d348e4caf3c5ae86eb66e34793afe",
            "3076301006072a8648ce3d020106052b81040022036200041fab4df6996a50d50effb7a1a9ca9e53bd8666ec9fb2fe1c8c77e1c5d9bc18ecfa93a93c619df78d1c00e7180a14326f24f6aa289da5dabb3094fc82084d20f6cd9913d759dece8652ca1f3010ac4312d5a2e97ff6f287f6089b8cea4d0292c1",
            "3076301006072a8648ce3d020106052b81040022036200043e12ef5a351841f918ccc66fdc1f570403ef6e5f9fbcd7d75623f33d0aae4c633ffe620ada9b7e48c5c418417d2cf49a1be83e0d8f79805da153df0409dae73dd425e232188b11f91c8bb9c8a2347f56c8d897303ad0f496a234fe2c77d30d3b",
            "3076301006072a8648ce3d020106052b81040022036200040d5fd8b4a5291fd89970dbbe413598951ea035443dbec41e68fd678399c7ef1ffec040258101a1d13e62a6587d5d9480b21cb43a7b6170f39fe907ef716d4f3eb6f35806077a053a627a4ce65459ff790d3c454bcc756bb6ac269793f8946a80",
            "3076301006072a8648ce3d020106052b810400220362000458fc0f9e905048bcf8f67cc2b649697abb42656790767059aab67cd1c7931c63991cee3bf31d65e53355b582f74084b98b6d6578c34ab62cac908a14488d5fe0a1aaf51be78c620779afa8795c3409adbbe9c8ea3dc1b3452617f1b6af1a2347",
            "3076301006072a8648ce3d020106052b81040022036200044d1bce647674ca154236c12b87e632a1c1a7011fd8fd7c70d0be65b256f8edefea2d449333cafbd6fe8ba57463b008f5ff6898583cada8f53bbae57117af82dd43fca50cd9529d1ad7a1559011a332ff3e884a5a45fd17122f1550f84df1cb1f",
            "3076301006072a8648ce3d020106052b8104002203620004377d505faa1e19f610bc93018f20b2785055e3b470f4b39eb16a741d6712fcb4a5a50fc8396f8ed99a195a61450584ab42df012cb15f8ea00ac96f685fed4fa9d1651d552f6fc450aa58318372ca16b6076122bc77ba163a1ccb5f00cad05bad",
            "3076301006072a8648ce3d020106052b81040022036200040c76cba89ca3a84d6ac7a514eb0cad415099ed10cabbac97be643cd0001bab37c88abc62c48071cc8262b87b96155fab82bf04624325cdbeda758f004a7b21264fb01ae11cdd15701eb81795c06d6c9bfd70ff5dda968b8c0f665c2f27656766",
            "3076301006072a8648ce3d020106052b810400220362000457b1bc3b367058867b321b28e54f9b6d94d1c00b183769de5933af63a7dcaaf0cd9d4a317fb198601b2e09d9616ad707b0af2b2e09b0d38187d9e489a52557a22db7ce5851afd96c7398835313cdb5402c2d601c3a442b6f4ac15272846a964d",
            "3076301006072a8648ce3d020106052b8104002203620004dfa0af52a5cb2953457c5266976c17cc1ad10d815b2cce203fd4c28cc23b6511531daf47f48d8aff24808e68b2187c956ca22a8a76a38d0a0955c1d4de49e3f9a7d4e5f0a03cc5f37d76af3fb8d424754d13f7fb7f2b7162add802430c3ea12d",
            "3076301006072a8648ce3d020106052b8104002203620004c6bb12db7ed67ab77e8b2d9d0192f8e036dbf351876411d91b0457262ac8e804cec87fce5b313db0d7790a5f66de3c729e596a9d3145872f3c015829a38ffd49c9abea3579f3f4476e25fd287d16dc7f6eda02173edcb63e39e20cddd9256d11",
            "3076301006072a8648ce3d020106052b8104002203620004906263e41675f8e2c23869de2fcb03e1331c2b92abb920bd1b95c0a92e28e934f4ed1e0372f4106cf46816801c15c36f6bb675d1529796e87e95e95562aa10cb3e2a6c160cd650d3ec538c38b8cca7e0f1c6fc5f8869e31b8413e5e9a0353820",
            "3076301006072a8648ce3d020106052b8104002203620004d18c01d532b617580b2f6c859b008f6c39b33136a9cb3a711a7810b9394ec05b12303d9e4dba64bebaca339ac78b96f0c9de0b7e466b48979de9a7158a5dc095361b006f804099b3f12ad8263fcd114ee6c215cc559c5274df14b96cb63a051c",
            "3076301006072a8648ce3d020106052b8104002203620004b4d666093be14a41476221f9ae7edd449f04cd46905bcb9eb13f76a08b9483834a252fb60563e8aaa1138cd258d295b61d81d826d2d95c8a3651def2ee976e4fbaf3fdbdddc2bcf254af796cbfb9b13d9a4ca957cb67d04225b6c4715c518d65",
            "3076301006072a8648ce3d020106052b8104002203620004300b16ccefb3d4e4ebef87fa92ece6bf751e5b2cb744975f1eea6644c4c7fc74fc7a1cfb7e77237880e062e857fcb7c4b151c870b971fa9791cb3d39594e5b6d6e3b9ef51df467abd4030799cdc0faea3b81369f4cc57a5d311212d2d7b00125",
            "3076301006072a8648ce3d020106052b8104002203620004fb9a62fa785924febace1e1e3c4bbd778cebee838e85e38c829bb79836f8f4091c63c10f8d39af5092d5f49bacc152ee8d389e51a0e620539528c72082f187e9865f8c8e806a5f9dc8763cd8612be89318b5f3c916b0cb51b2ed9d44ee2f3522",
            "3076301006072a8648ce3d020106052b8104002203620004c2c1de971a8314fac6feeabf325fa5b884c2832afac5457e84a2013f8bb8dd50004ce890e176b5b279d98880edcd3fcda6e002a2fddc4f9ec1fb59eb7f20c40a181001958e01510127da3b169922c1ef1405299ca721cc33b1d74814f156bd09",
            "3076301006072a8648ce3d020106052b81040022036200042e6897276a35acb0910f240df16b0c702e0b61d27059f43e30c9349b1039f71b63081306bb4febfcd00656e9b2c85b601070223fadca9bd7ddf8719a1419b6e0421821fbd4d3f82683f32f83934e7c91e02ebd3066471aea44a531e0f93eab4e",
            "3076301006072a8648ce3d020106052b8104002203620004e8bc4e9c822e94fc2d259a78be0c02601b38097fd1840136879fca45109d58cebd6ba98c47899a771547fb78cd1d5cf4853dafc33a2eba2485d641671ddf29c5d6286e5805fd3d8dbb5ae756e588607bf34d29e1c120bd184a2d32f491d30436",
            "3076301006072a8648ce3d020106052b810400220362000449210944a973d70dd08ce76bdc036d14a532b28a831813bc5cdba22f422f2c0fc77b39d5759c32b57ef20b9356cbe4cb95c0b9bf2fac64abde679b17ab544527079890377bacf2bd66037a92493cd8f18d7d02adba185581639c4b6e9606b4a7",
            "3076301006072a8648ce3d020106052b81040022036200049a6cd294cc252eacd5945683ed03de548b434efd5d52304766cb62156873825575afd031c8465c86f5bddf18246c5b63fe7ec9c9a00984aa7ffa0b31b610f3f591931e46372dc3344dba7c63964c7cf4f9b5f679bf647d8ae84ff3d2091f1ce2",
            "3076301006072a8648ce3d020106052b8104002203620004ab58e7f83f12675d5b815a9e23f8afcf03583b50a11b177ab90eece7af99d821b43d111154aa8912ebf789f46ea3c689a67e3c247d5ab9c9a9cb9999bdfab6bf5338b8737742caff54e58ddf00f46d60445650a149bf68c350b823f2e7fd0102",
            "3076301006072a8648ce3d020106052b8104002203620004ac4c6988dc6cd8f1749a0196df2f863fbdd5819c1c11dbe60cfaa9e4f450e8e78d2dd4ff848ced9635daa52581c63d2ea422a0ad058e5c54e7f0cdcd4fa200ef1c9f9d492516cb282c950e5cce3abe47fb3127172f7d9dcb7bfe6ecfd924f325",
            "3076301006072a8648ce3d020106052b81040022036200045093d4090aa6b62247c56c7ad738a762ec5646936472542ed8e9ea8526fa0c2ea373e849f691018b64e3b83a8f26d32c9a2470fcab2c3bf8b385817f279b0426d9cce24bb194e8a1d9013f4138ffed8a0bc7eb40574e86b8dac8022f975670e2",
            "3076301006072a8648ce3d020106052b81040022036200042230f4ed7a10f266ece73207670261098d076fa4f53b828061272758092de91141049da022e0b1496db8e078c5abb174771b09bfe7244da7caada2e0275821589e38fca1e978bec942c240f31653d3aa6880958de8554a4e4e6d1bc27d41540f",
            "3076301006072a8648ce3d020106052b8104002203620004b98dbdf440ed2a6e28584eee773c79f55717edf22e4b1f8b8d9bdb0353aa9d97745439eb3f4667ab2b0c882f2023ee2517b1e3582098ca7c75fda1eb7512ba237bb6af5498b8fd309c626b77633e5ce2c5dc52f6656b76fb7605817fb8c0aeea",
            "3076301006072a8648ce3d020106052b81040022036200041d1911e5ffb7caad76e9b9d575949b2566e07e4b1baa66ab3622597636e9f305a288c75f9ca14f12416404cf33d5ece451773e7791adb92dcc3b8e3c2a5fca946c2e56d844a771b26d8e88ef2ee5f56a3c5ee412c3451d09ef19eee9126fc2b2",
            "3076301006072a8648ce3d020106052b8104002203620004b39009e4712b92a4148fee60af9db47479c4717d0874abcdf7244ca9f8ab1a5807ef21510ced3d93db9dd43bb20c74580d111ab5281fa231f5708df6c213a0c704e78142dfd3eb8239f9be07f8c24cb528f42eee2d82e2662436631d291c3d07",
            "3076301006072a8648ce3d020106052b8104002203620004fcf2985c96bb6658541b6cb530808970a43a05ce8ca8dafc4b763f93d232e1bcc7d18eeabe57b6e68caf233becb593b4f383323c95251ae263dd636e95a52d4f50b584c1dc5d43f87d229a908e76d6baea8bd7e4e552ffed2e5577a750d8ba4b",
            "3076301006072a8648ce3d020106052b810400220362000457d3d89a1af62e834d5984a3f17defe9ed36b648ac50d9e5eef78f72a282bb7dd0fcfa47b034780971a674d6f5257480370880296cbf3e4e4a59a2c27527c8244c43f8e7cbf4c133a52ca297ab609ef91912fb7cc73f3e604f74f611e7b0e9c2");

    public static void main(String[] args) throws NoSuchAlgorithmException {
        int number = 30;

        StringBuilder sb = new StringBuilder();
        sb.append("public static List<String> ecPublicKeys = List.of(\n");
        for (int i = 0; i < number; i++) {
            // KeyPair keyPair = KeyUtils.generateKeyPair(KeyType.RSA, 3072, SecureRandom.getInstanceStrong());
            KeyPair keyPair = KeyUtils.generateKeyPair(KeyType.EC, 384, SecureRandom.getInstanceStrong());
            String hex = CommonUtils.hex(keyPair.getPublic().getEncoded());

            sb.append('"');
            sb.append(hex);
            sb.append('"');
            if (i < number - 1) {
                sb.append(',');
            }
            sb.append('\n');
        }
        sb.append(");\n");
        System.out.println(sb.toString());
    }

    public static SerializablePublicKey getPublicKey(KeyType keyType, long id) {
        return new SerializablePublicKey(SerializablePublicKey.bytesToPublicKey(
                CommonUtils.unhex(
                        keyType == KeyType.RSA
                                ? rsaPublicKeys.get((int) (id % rsaPublicKeys.size()))
                                : ecPublicKeys.get((int) (id % ecPublicKeys.size()))),
                keyType.name()));
    }
}
