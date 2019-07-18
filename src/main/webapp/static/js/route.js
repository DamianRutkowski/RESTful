/**
 * Created by Damian Rutkowski on 2015-09-27.
 */

app.config(["$locationProvider", function ($locationProvider) {
    $locationProvider.html5Mode(true);
}]);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'partials/home.html',
            controller: 'HomeCtrl',
            resolve: {
                articles: function (Article) {
                    return Article.query().$promise;
                }
            }
        })
        .state('article', {
            url: '/article/{tagName}',
            templateUrl: 'partials/article/index.html',
            controller: 'ArticleCtrl',
            resolve: {
                article: function (Article, $stateParams) {
                    return Article.get({tagName: $stateParams.tagName}).$promise;
                }
            }
        })
        /*
        .state('auctions', {
            url: '/auctions',
            templateUrl: 'partials/auction/index.html',
            controller: 'AuctionCtrl',
            resolve: {
                auctions: function (Auction) {
                    return Auction.query().$promise;
                },
                auctionCategories: function (AuctionCategory) {
                    return AuctionCategory.query().$promise;
                }
            }
        })
        .state('auctions.category', {
            url: '/{tagName}',
            templateUrl: 'partials/auction/category.html',
            controller: 'AuctionCategoryCtrl',
            resolve: {
                currentCategory: function (auctionCategories, $filter, $stateParams) {
                    return $filter('filter')(auctionCategories, function (d) {
                        return d.tagName == $stateParams.tagName;
                    }) [0];
                },

                categoryAuctions: function (auctions, $filter, $stateParams) {
                    return $filter('filter')(auctions, function (d) {
                        return d.auctionCategory.tagName == $stateParams.tagName;
                    });
                }
            }
        })
        .state('auctionDetail', {
            url: '/auction-detail/{id}',
            templateUrl: 'partials/auction/detail.html',
            controller: 'AuctionDetailCtrl',
            resolve: {
                auction: function (Auction, $stateParams) {
                    return Auction.get({id: $stateParams.id}).$promise;
                }
            }
        }) */
        .state('login', {
            url: '/login',
            templateUrl: 'partials/login.html'
        })
        .state('registration', {
            url: '/registration',
            templateUrl: 'partials/registration.html',
            controller: 'RegistrationCtrl'
        })
        .state('forum', {
            url: '/forum',
            templateUrl: 'partials/forum/index.html',
            controller: 'ForumCtrl',
            resolve: {
                categories: function (ForumCategory) {
                    return ForumCategory.query().$promise;
                }
            }
        })
        .state('forumSubcategory', {
            url: '/forum/category/{tagName}',
            templateUrl: 'partials/forum/subcategory.html',
            controller: 'ForumSubcategoryCtrl',
            resolve: {
                category: function (ForumSubcategory, $stateParams) {
                    return ForumSubcategory.get({tagName: $stateParams.tagName}).$promise;
                },
                threads: function (SubcategoryThreads, $stateParams) {
                    return SubcategoryThreads.get({tagName: $stateParams.tagName}).$promise;
                }
            }
        })
        .state('thread', {
            url: '/forum/thread/{id}',
            templateUrl: 'partials/forum/thread.html',
            controller: 'ThreadCtrl',
            resolve: {
                thread: function (Thread, $stateParams) {
                    return Thread.get({id: $stateParams.id}).$promise;
                }
            }
        })
        .state('encyclopedia', {
            url: '/encyclopedia',
            templateUrl: 'partials/encyclopedia/index.html',
            controller: 'EncyclopediaCtrl',
            resolve: {
                categories: function (WeaponCategory) {
                    return WeaponCategory.query().$promise;
                },
                weapons: function (Weapon) {
                    return Weapon.query().$promise;
                }
            }
        })
        .state('encyclopedia.category', {
            url: '/{tagName}',
            templateUrl: 'partials/encyclopedia/category.html',
            controller: 'EncyclopediaCategoryCtrl',
            resolve: {
                currentCategory: function (categories, $filter, $stateParams) {
                    return $filter('filter')(categories, function (d) {
                        return d.tagName == $stateParams.tagName;
                    }) [0];
                },

                categoryWeapons: function (weapons, $filter, $stateParams) {
                    return $filter('filter')(weapons, function (d) {
                        return d.weaponCategory.tagName == $stateParams.tagName;
                    });
                }
            }
        })
        .state('encyclopediaDetail', {
            url: '/weapon-detail/{tagName}',
            templateUrl: 'partials/encyclopedia/detail.html',
            resolve: {
                weapon: function (Weapon, $stateParams) {
                    return Weapon.get({tagName: $stateParams.tagName}).$promise;
                }
            },
            controller: 'WeaponCtrl'
        })
        .state('userProfile', {
            url: '/profile/{username}',
            templateUrl: 'partials/profile/userProfile.html',
            resolve: {
                user: function (User, $stateParams) {
                    return User.get({username: $stateParams.username}).$promise;
                },

                profileMessages: function (UserMessage, $stateParams) {
                    return UserMessage.query({targetUser: $stateParams.username}).$promise;
                }
            },
            controller: 'UserProfileCtrl'
        })
        .state('pm', {
            url: '/private-messages',
            templateUrl: 'partials/profile/privateMessages.html',
            resolve: {
                pmSent: function (PrivateMessage, $rootScope) {
                    return PrivateMessage.query({sender: $rootScope.userPrincipal.username}).$promise;
                },
                pmReceived: function (PrivateMessage, $rootScope) {
                    return PrivateMessage.query({recipient: $rootScope.userPrincipal.username}).$promise;
                }
            },
            controller: 'PMCtrl'
        })
        .state('admin', {
            url: '/admin',
            templateUrl: 'partials/admin/index.html',
            resolve: {
                users: function (User) {
                    return User.query().$promise;
                },
                employees: function (Employee) {
                    return Employee.query().$promise;
                }
            },
            controller: 'AdminUserCtrl'
        })
        .state('admin.edit', {
            url: '/edit',
            templateUrl: 'partials/admin/edit.html',
            resolve: {
                roles: function (Role) {
                    return Role.query().$promise;
                }
            },
            controller: 'AdminUserModifyCtrl'
        })
        .state('employee', {
            url: '/employee',
            templateUrl: 'partials/employee/index.html'
        })
        .state('employee.users', {
            url: '/users',
            templateUrl: 'partials/employee/users/index.html',
            resolve: {
                users: function (User) {
                    return User.query().$promise;
                }
            },
            controller: 'EmployeeUserCtrl'
        })
        .state('employee.users.edit', {
            url: '/edit',
            templateUrl: 'partials/employee/users/edit.html',
            controller: 'EmployeeUsersModifyCtrl'
        })
        .state('employee.auctions', {
            url: '/auctions',
            templateUrl: 'partials/employee/auctions/index.html'
        })
        .state('employee.auctions.category', {
            url: '/category',
            templateUrl: 'partials/employee/auctions/category/index.html',
            resolve: {
                categories: function (AuctionCategory) {
                    return AuctionCategory.query().$promise;
                }
            },
            controller: 'EmployeeAuctionsCategoryCtrl'
        })
        .state('employee.auctions.category.add', {
            url: '/add',
            templateUrl: 'partials/employee/auctions/category/add.html',
            controller: 'EmployeeAuctionsCategoryModifyCtrl'
        })
        .state('employee.auctions.category.edit', {
            url: '/edit',
            templateUrl: 'partials/employee/auctions/category/edit.html',
            controller: 'EmployeeAuctionsCategoryModifyCtrl'
        })
        .state('employee.auctions.auction', {
            url: '/auction',
            templateUrl: 'partials/employee/auctions/auction/index.html',
            resolve: {
                auctions: function (Auction) {
                    return Auction.query().$promise;
                },
                categories: function (AuctionCategory) {
                    return AuctionCategory.query().$promise;
                }
            },
            controller: 'EmployeeAuctionsCtrl'
        })
        .state('employee.auctions.auction.edit', {
            url: '/edit',
            templateUrl: 'partials/employee/auctions/auction/edit.html',
            controller: 'EmployeeAuctionsAuctionModifyCtrl'
        })
        .state('employee.encyclopedia', {
            url: '/encyclopedia',
            templateUrl: 'partials/employee/encyclopedia/index.html'
        })
        .state('employee.encyclopedia.category', {
            url: '/category',
            templateUrl: 'partials/employee/encyclopedia/category/index.html',
            resolve: {
                categories: function (WeaponCategory) {
                    return WeaponCategory.query().$promise;
                }
            },
            controller: 'EmployeeEncyclopediaCategoryCtrl'
        })
        .state('employee.encyclopedia.category.add', {
            url: '/add',
            templateUrl: 'partials/employee/encyclopedia/category/add.html',
            controller: 'EmployeeEncyclopediaCategoryModifyCtrl'
        })
        .state('employee.encyclopedia.category.edit', {
            url: '/edit',
            templateUrl: 'partials/employee/encyclopedia/category/edit.html',
            controller: 'EmployeeEncyclopediaCategoryModifyCtrl'
        })
        .state('employee.encyclopedia.weapon', {
            url: '/weapon',
            templateUrl: 'partials/employee/encyclopedia/weapon/index.html',
            resolve: {
                weapons: function (Weapon) {
                    return Weapon.query().$promise;
                },
                categories: function (WeaponCategory) {
                    return WeaponCategory.query().$promise;
                }
            },
            controller: 'EmployeeWeaponCtrl'
        })
        .state('employee.encyclopedia.weapon.add', {
            url: '/add',
            templateUrl: 'partials/employee/encyclopedia/weapon/add.html',
            controller: 'EmployeeWeaponModifyCtrl'
        })
        .state('employee.encyclopedia.weapon.edit', {
            url: '/edit',
            templateUrl: 'partials/employee/encyclopedia/weapon/edit.html',
            controller: 'EmployeeWeaponModifyCtrl'
        })
        .state('employee.article', {
            url: '/articles',
            templateUrl: 'partials/employee/articles/index.html',
            resolve: {
                articles: function (Article) {
                    return Article.query().$promise;
                }
            },
            controller: 'EmployeeArticleCtrl'
        })
        .state('employee.article.add', {
            url: '/add',
            templateUrl: 'partials/employee/articles/add.html',
            controller: 'EmployeeArticleModifyCtrl'
        })
        .state('employee.article.edit', {
            url: '/edit',
            templateUrl: '/partials/employee/articles/edit.html',
            controller: 'EmployeeArticleModifyCtrl'
        })

});