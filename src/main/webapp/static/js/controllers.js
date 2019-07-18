/**
 * Created by Damian Rutkowski on 2015-09-27.
 */

app.controller('LoginCtrl', function ($rootScope, $scope, $http, $location) {

    var authenticate = function (credentials, callback) {
        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('api/user', {headers: headers}).success(function (data) {
            if (data) {
                $rootScope.userPrincipal = data;
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }).error(function () {
            $rootScope.authenticated = false;
            callback && callback();
        });

    }

    authenticate();
    $scope.credentials = {};
    $scope.login = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/");
                $scope.error = false;
            } else {
                $location.path("/login");
                $scope.error = true;
            }
        });
    };

    $scope.logout = function () {
        $http.post('logout', {}).success(function () {
            $rootScope.authenticated = false;
        }).error(function (data) {
            $rootScope.authenticated = true;
        });


        window.location.reload(true);
    };

    $scope.checkAuthority = function (authority) {
        if ($scope.userPrincipal == null) {
            return false;
        }

        for (i = 0; i < $scope.userPrincipal.roles.length; i++) {
            if ($scope.userPrincipal.roles[i].authority == authority) {
                return true;
            }
        }
        return false;
    }

});

app.controller('RegistrationCtrl', function ($scope, User, $state) {
    $scope.register = function () {
        var user = new User();

        user.username = $scope.user.username;
        user.password = $scope.user.password;
        user.email = $scope.user.email;
        user.lastName = $scope.user.lastName;
        user.firstName = $scope.user.firstName;
        user.address = $scope.user.address;

        user.$save();

        alert("Registration e-mail has been sent to your e-mail address.");
        $state.go('home');
    }

});

app.controller('HomeCtrl', function ($scope, articles) {
    $scope.articles = articles;
});

app.controller('ArticleCtrl', function ($scope, article, ArticleComment) {
    $scope.article = article;

    $scope.add = function (newComment) {
        var comment = new ArticleComment();
        comment.content = newComment.content;
        comment.article = $scope.article;

        var user = $scope.userPrincipal;
        comment.author = user;

        comment.$save();
        window.location.reload(true);
    };
});

app.controller('EncyclopediaCtrl', function ($scope, $state, categories, weapons) {
    $scope.categories = categories;
    $scope.weapons = weapons;

    $scope.isCategoryChosen = false;
});

app.controller('EncyclopediaCategoryCtrl', function ($scope, currentCategory, categoryWeapons, $state) {
    if (currentCategory == undefined) {
        $state.go('encyclopedia');
    }

    $scope.currentCategory = currentCategory;
    $scope.categoryWeapons = categoryWeapons;

    $scope.isCategoryChosen = true;
});

app.controller('WeaponCtrl', function ($scope, weapon, WeaponComment) {
    $scope.weapon = weapon;

    $scope.add = function (newComment) {
        var comment = new WeaponComment();
        comment.content = newComment.content;
        comment.weapon = $scope.weapon;

        var user = $scope.userPrincipal;
        comment.author = user;

        comment.$save();
        window.location.reload(true);
    };
});

app.controller('ForumCtrl', function ($scope, categories, ForumCategory, ForumSubcategory) {
    $scope.categories = categories;

    $scope.addCategory = function (newCategory) {
        var category = new ForumCategory();
        category.name = newCategory.name;

        category.$save();
        window.location.reload(true);
    };
    $scope.editCategory = function (category) {
        category.$update();
        window.location.reload(true);
    }

    $scope.removeCategory = function (id) {
        ForumCategory.remove({id: id});
        window.location.reload(true);
    }

    $scope.addSubcategory = function (newSubcategory, category) {
        var subcategory = new ForumSubcategory();
        subcategory.tagName = newSubcategory.tagName;
        subcategory.name = newSubcategory.name;
        subcategory.category = category;

        subcategory.$save();
        window.location.reload(true);
    };
});

app.controller('ForumSubcategoryCtrl', function ($scope, Thread, Post, category, threads) {
    $scope.category = category;
    $scope.threads = threads;

    $scope.add = function (newThread) {

        var thread = new Thread();
        thread.subject = newThread.subject;
        thread.user = $scope.userPrincipal;
        thread.forumSubcategory = $scope.category;

        var post = new Post();
        post.content = $scope.postContent;
        post.user = $scope.userPrincipal;
        post.thread = thread;
        post.$save();

        window.location.reload(true);

    };
});

app.controller('ThreadCtrl', function ($scope, thread, Post) {
    $scope.thread = thread;

    $scope.add = function (newPost) {
        var post = new Post();
        post.content = newPost.content;
        post.user = $scope.userPrincipal;
        post.thread = thread;

        post.$save();

        window.location.reload(true);
    }
});

app.controller('UserProfileCtrl', function ($scope, $state, user, profileMessages, UserMessage, PrivateMessage) {
    $scope.user = user;
    $scope.profileMessages = profileMessages;


    $scope.add = function (newComment) {
        var comment = new UserMessage();

        comment.content = newComment.content;
        comment.targetUser = user;
        comment.author = $scope.userPrincipal;

        comment.$save();
        window.location.reload(true);
    }

    $scope.sendPW = function (message) {
        var pw = new PrivateMessage();
        pw.content = message.content;
        pw.recipient = user;
        pw.sender = $scope.userPrincipal;

        pw.$save();
        window.location.reload(true);
    }
});

app.controller('PMCtrl', function ($scope, pmSent, pmReceived) {
    $scope.pmSent = pmSent;
    $scope.pmReceived = pmReceived;

    console.log('pm');
    console.log(pmSent);
    console.log(pmReceived);
});

app.controller('AdminUserCtrl', function ($scope, users, employees, User) {
    $scope.users = users;
    $scope.employees = employees;

    $scope.setUser = function (user) {
        $scope.user = user;
    };

    $scope.remove = function (username) {
        User.remove({username: username});

        window.location.reload(true);
    }
});

app.controller('AdminUserModifyCtrl', function ($scope, roles) {
    $scope.roles = roles;

    $scope.edit = function (user) {
        console.log('user: ' + user.username + user.roles);
        user.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeAuctionsCtrl', function ($scope, auctions, categories, Auction) {
    $scope.auctions = auctions;
    $scope.categories = categories;

    $scope.setAuction = function (auction) {
        $scope.auction = auction;
    }

    $scope.remove = function (id) {
        Auction.remove({id: id});

        window.location.reload(true);
    }
});

app.controller('EmployeeAuctionsCategoryCtrl', function ($scope, categories, AuctionCategory) {
    $scope.categories = categories;

    $scope.setCategory = function (category) {
        $scope.category = category;
    };

    $scope.remove = function (id) {
        AuctionCategory.remove({id: id});
        window.location.reload(true);
    };
});

app.controller('EmployeeAuctionsAuctionModifyCtrl', function ($scope) {
    $scope.edit = function (auction) {
        auction.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeAuctionsCategoryModifyCtrl', function ($scope, AuctionCategory) {

    $scope.add = function (newCategory) {

        var category = new AuctionCategory();
        category.tagName = newCategory.tagName;
        category.name = newCategory.name;

        category.$save();
        window.location.reload(true);
    }

    $scope.edit = function (category) {
        category.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeEncyclopediaCategoryCtrl', function ($scope, categories, WeaponCategory) {
    $scope.categories = categories;

    $scope.setCategory = function (category) {
        $scope.category = category;
    };

    $scope.remove = function (id) {
        WeaponCategory.remove({id: id});
        window.location.reload(true);
    };
});

app.controller('EmployeeEncyclopediaCategoryModifyCtrl', function ($scope, WeaponCategory) {

    $scope.add = function (newCategory) {

        var category = new WeaponCategory();
        category.tagName = newCategory.tagName;
        category.name = newCategory.name;
        category.description = newCategory.description;

        category.$save();
        window.location.reload(true);
    }

    $scope.edit = function (category) {
        category.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeWeaponCtrl', function ($scope, weapons, categories, Weapon, WeaponCategory) {
    $scope.weapons = weapons;

    $scope.categories = categories;

    $scope.setWeapon = function (weapon) {
        $scope.weapon = weapon;
    };

    $scope.remove = function (tagName) {
        Weapon.remove({tagName: tagName});
        window.location.reload(true);
    };
});

app.controller('EmployeeWeaponModifyCtrl', function ($scope, Weapon) {

    $scope.add = function (newWeapon) {

        var weapon = new Weapon();
        weapon.tagName = newWeapon.tagName;
        weapon.name = newWeapon.name;
        weapon.description = newWeapon.description;
        weapon.weaponCategory = newWeapon.weaponCategory;

        weapon.$save();
        window.location.reload(true);
    }

    $scope.edit = function (weapon) {
        weapon.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeArticleCtrl', function ($scope, articles, Article) {
    $scope.articles = articles;

    $scope.setArticle = function (article) {
        $scope.article = article;
    };

    $scope.remove = function (tagName) {
        Article.remove({tagName: tagName});
        window.location.reload(true);
    };
});

app.controller('EmployeeArticleModifyCtrl', function ($scope, Article) {

    $scope.add = function (newArticle) {

        var article = new Article();
        article.tagName = newArticle.tagName;
        article.subject = newArticle.subject;
        article.content = newArticle.content;

        var user = $scope.userPrincipal;
        article.author = user;

        console.log("user: " + user + " " + user.username);
        $scope.articleTest = article;

        article.$save();
        window.location.reload(true);
    }

    $scope.edit = function (article) {
        var user = $scope.userPrincipal;
        article.author = user;

        article.$update();
        window.location.reload(true);
    }
});

app.controller('EmployeeUserCtrl', function ($scope, users) {
    $scope.users = users;

    $scope.setUser = function (user) {
        $scope.user = user;
    };

})

app.controller('EmployeeUsersModifyCtrl', function ($scope, User) {
    $scope.edit = function (user) {
        user.$update();
    }
});

app.controller('NewItemCtrl', function ($scope, categories, weapons) {
    $scope.categories = categories;
    $scope.weapons = weapons;
});